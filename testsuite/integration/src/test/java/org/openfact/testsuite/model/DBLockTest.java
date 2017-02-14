package org.openfact.testsuite.model;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.jboss.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.models.dblock.DBLockManager;
import org.openfact.models.dblock.DBLockProvider;
import org.openfact.models.dblock.DBLockProviderFactory;
import org.openfact.models.utils.OpenfactModelUtils;

public class DBLockTest extends AbstractModelTest {

    private static final Logger log = Logger.getLogger(DBLockTest.class);

    private static final int SLEEP_TIME_MILLIS = 10;
    private static final int THREADS_COUNT = 20;
    private static final int ITERATIONS_PER_THREAD = 2;

    private static final int LOCK_TIMEOUT_MILLIS = 240000; // Rather bigger to handle slow DB connections in testing env
    private static final int LOCK_RECHECK_MILLIS = 10;

    @Before
    @Override
    public void before() throws Exception {
        super.before();

        // Set timeouts for testing
        DBLockManager lockManager = new DBLockManager(session);
        DBLockProviderFactory lockFactory = lockManager.getDBLockFactory();
        lockFactory.setTimeouts(LOCK_RECHECK_MILLIS, LOCK_TIMEOUT_MILLIS);

        // Drop lock table, just to simulate racing threads for create lock table and insert lock record into it.
        lockManager.getDBLock().destroyLockInfo();

        commit();
    }

    @Test
    public void testLockConcurrently() throws Exception {
        long startupTime = System.currentTimeMillis();

        final Semaphore semaphore = new Semaphore();
        final OpenfactSessionFactory sessionFactory = organizationManager.getSession().getOpenfactSessionFactory();

        List<Thread> threads = new LinkedList<>();
        for (int i = 0; i < THREADS_COUNT; i++) {
            Thread thread = new Thread() {

                @Override
                public void run() {
                    for (int i = 0; i < ITERATIONS_PER_THREAD; i++) {
                        try {
                            OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

                                @Override
                                public void run(OpenfactSession session) {
                                    lock(session, semaphore);
                                }

                            });
                        } catch (RuntimeException e) {
                            semaphore.setException(e);
                            throw e;
                        }
                    }
                }

            };
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        long took = (System.currentTimeMillis() - startupTime);
        log.infof("DBLockTest executed in %d ms with total counter %d. THREADS_COUNT=%d, ITERATIONS_PER_THREAD=%d", took, semaphore.getTotal(), THREADS_COUNT, ITERATIONS_PER_THREAD);
        Assert.assertEquals(semaphore.getTotal(), THREADS_COUNT * ITERATIONS_PER_THREAD);
        Assert.assertNull(semaphore.getException());
    }

    private void lock(OpenfactSession session, Semaphore semaphore) {
        DBLockProvider dbLock = new DBLockManager(session).getDBLock();
        dbLock.waitForLock();
        try {
            semaphore.increase();
            Thread.sleep(SLEEP_TIME_MILLIS);
            semaphore.decrease();
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        } finally {
            dbLock.releaseLock();
        }
    }


    // Ensure just one thread is allowed to run at the same time
    private class Semaphore {

        private AtomicInteger counter = new AtomicInteger(0);
        private AtomicInteger totalIncreases = new AtomicInteger(0);

        private volatile Exception exception = null;

        private void increase() {
            int current = counter.incrementAndGet();
            if (current != 1) {
                IllegalStateException ex = new IllegalStateException("Counter has illegal value: " + current);
                setException(ex);
                throw ex;
            }
            totalIncreases.incrementAndGet();
        }

        private void decrease() {
            int current = counter.decrementAndGet();
            if (current != 0) {
                IllegalStateException ex = new IllegalStateException("Counter has illegal value: " + current);
                setException(ex);
                throw ex;
            }
        }

        private synchronized void setException(Exception exception) {
            if (this.exception == null) {
                this.exception = exception;
            }
        }

        private synchronized Exception getException() {
            return exception;
        }

        private int getTotal() {
            return totalIncreases.get();
        }
    }

}
