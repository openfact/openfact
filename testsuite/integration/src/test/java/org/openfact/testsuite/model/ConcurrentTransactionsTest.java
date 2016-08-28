package org.openfact.testsuite.model;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.jboss.logging.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactModelUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.models.OrganizationModel;

public class ConcurrentTransactionsTest extends AbstractModelTest {

    private static final Logger logger = Logger.getLogger(ConcurrentTransactionsTest.class);

    /*@Test
    public void persistClient() throws Exception {
        OrganizationModel realm = organizationManager.createOrganization("original");
        OpenfactSession session = organizationManager.getSession();

        ClientModel client = session.realms().addClient(realm, "client");
        client.setSecret("old");

        String clientDBId = client.getId();

        final OpenfactSessionFactory sessionFactory = session.getOpenfactSessionFactory();
        commit();

        final CountDownLatch transactionsCounter = new CountDownLatch(2);
        final CountDownLatch readLatch = new CountDownLatch(1);
        final CountDownLatch updateLatch = new CountDownLatch(1);

        Thread thread1 = new Thread() {

            @Override
            public void run() {
                OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

                    @Override
                    public void run(OpenfactSession session) {
                        try {
                            // Wait until transaction in both threads started
                            transactionsCounter.countDown();
                            logger.info("transaction1 started");
                            transactionsCounter.await();

                            // Read client
                            OrganizationModel realm = session.realms().getOrganizationByName("original");
                            ClientModel client = session.realms().getClientByClientId("client", realm);
                            logger.info("transaction1: Read client finished");
                            readLatch.countDown();

                            // Wait until thread2 updates client and commits
                            updateLatch.await();
                            logger.info("transaction1: Going to read client again");

                            client = session.realms().getClientByClientId("client", realm);
                            logger.info("transaction1: secret: " + client.getSecret());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                });
            }

        };

        Thread thread2 = new Thread() {

            @Override
            public void run() {
                OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

                    @Override
                    public void run(OpenfactSession session) {
                        try {
                            // Wait until transaction in both threads started
                            transactionsCounter.countDown();
                            logger.info("transaction2 started");
                            transactionsCounter.await();


                            readLatch.await();
                            logger.info("transaction2: Going to update client secret");

                            OrganizationModel realm = session.realms().getOrganizationByName("original");
                            ClientModel client = session.realms().getClientByClientId("client", realm);
                            client.setSecret("new");
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                });

                logger.info("transaction2: commited");
                updateLatch.countDown();
            }

        };

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        logger.info("after thread join");

        commit();

        session = organizationManager.getSession();

        realm = session.realms().getOrganizationByName("original");
        ClientModel clientFromCache = session.realms().getClientById(clientDBId, realm);
        ClientModel clientFromDB = session.getProvider(OrganizationProvider.class).getClientById(clientDBId, realm);

        logger.info("SECRET FROM DB : " + clientFromDB.getSecret());
        logger.info("SECRET FROM CACHE : " + clientFromCache.getSecret());

        Assert.assertEquals("new", clientFromDB.getSecret());
        Assert.assertEquals("new", clientFromCache.getSecret());
    }*/


    // KEYCLOAK-3296
    @Test
    public void removeUserAttribute() throws Exception {
        OrganizationModel realm = organizationManager.createOrganization("original");
        OpenfactSession session = organizationManager.getSession();

        InvoiceModel user = session.invoices().addInvoice(realm, 1, 1);
        user.setSingleAttribute("foo", "val1");

        final OpenfactSessionFactory sessionFactory = session.getOpenfactSessionFactory();
        commit();

        AtomicReference<Exception> reference = new AtomicReference<>();

        final CountDownLatch readAttrLatch = new CountDownLatch(2);

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

                        @Override
                        public void run(OpenfactSession session) {
                            try {
                                // Read user attribute
                                OrganizationModel realm = session.organizations().getOrganizationByName("original");
                                InvoiceModel john = session.invoices().getInvoiceBySeriesAndNumber(1, 1, realm);
                                String attrVal = john.getFirstAttribute("foo");

                                // Wait until it's read in both threads
                                readAttrLatch.countDown();
                                readAttrLatch.await();

                                // Remove user attribute in both threads
                                john.removeAttribute("foo");
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }

                    });
                } catch (Exception e) {
                    reference.set(e);
                    throw new RuntimeException(e);
                } finally {
                    readAttrLatch.countDown();
                }
            }

        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        logger.info("removeUserAttribute: after thread join");

        commit();

        if (reference.get() != null) {
            Assert.fail("Exception happened in some of threads. Details: " + reference.get().getMessage());
        }
    }

}
