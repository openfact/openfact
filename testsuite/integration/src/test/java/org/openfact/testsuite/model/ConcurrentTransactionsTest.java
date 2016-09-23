/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openfact.testsuite.model;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.jboss.logging.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.UserModel;
import org.openfact.models.utils.OpenfactModelUtils;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public class ConcurrentTransactionsTest extends AbstractModelTest {

    private static final Logger logger = Logger.getLogger(ConcurrentTransactionsTest.class);

    /*@Test
    public void persistClient() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        OpenfactSession session = organizationManager.getSession();

        ClientModel client = session.organizations().addClient(organization, "client");
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
                            OrganizationModel organization = session.organizations().getOrganizationByName("original");
                            ClientModel client = session.organizations().getClientByClientId("client", organization);
                            logger.info("transaction1: Read client finished");
                            readLatch.countDown();

                            // Wait until thread2 updates client and commits
                            updateLatch.await();
                            logger.info("transaction1: Going to read client again");

                            client = session.organizations().getClientByClientId("client", organization);
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

                            OrganizationModel organization = session.organizations().getOrganizationByName("original");
                            ClientModel client = session.organizations().getClientByClientId("client", organization);
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

        organization = session.organizations().getOrganizationByName("original");
        ClientModel clientFromCache = session.organizations().getClientById(clientDBId, organization);
        ClientModel clientFromDB = session.getProvider(OrganizationProvider.class).getClientById(clientDBId, organization);

        logger.info("SECRET FROM DB : " + clientFromDB.getSecret());
        logger.info("SECRET FROM CACHE : " + clientFromCache.getSecret());

        Assert.assertEquals("new", clientFromDB.getSecret());
        Assert.assertEquals("new", clientFromCache.getSecret());
    }


    // OPENFACT-3296 , OPENFACT-3494
    @Test
    public void removeUserAttribute() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        OpenfactSession session = organizationManager.getSession();

        UserModel john = session.users().addUser(organization, "john");
        john.setSingleAttribute("foo", "val1");

        UserModel john2 = session.users().addUser(organization, "john2");
        john2.setAttribute("foo", Arrays.asList("val1", "val2"));

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
                                OrganizationModel organization = session.organizations().getOrganizationByName("original");
                                UserModel john = session.users().getUserByUsername("john", organization);
                                String attrVal = john.getFirstAttribute("foo");

                                UserModel john2 = session.users().getUserByUsername("john2", organization);
                                String attrVal2 = john2.getFirstAttribute("foo");

                                // Wait until it's read in both threads
                                readAttrLatch.countDown();
                                readAttrLatch.await();

                                // OPENFACT-3296 : Remove user attribute in both threads
                                john.removeAttribute("foo");

                                // OPENFACT-3494 : Set single attribute in both threads
                                john2.setSingleAttribute("foo", "bar");
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
    }*/

}
