package org.openfact.testsuite.model;

import org.jboss.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openfact.models.*;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.utils.OpenfactModelUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentTransactionsTest extends AbstractModelTest {

    private static final Logger logger = Logger.getLogger(ConcurrentTransactionsTest.class);

    @Test
    public void persistClient() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        OpenfactSession session = organizationManager.getSession();

        DocumentModel document = session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-123", organization);
        document.setCustomerElectronicMail("carlosthe19916@sistcoop.com");

        String documentDBId = document.getId();

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
                            DocumentModel document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE.toString(), "F01-123", organization);
                            logger.info("transaction1: Read document finished");
                            readLatch.countDown();

                            // Wait until thread2 updates client and commits
                            updateLatch.await();
                            logger.info("transaction1: Going to read document again");

                            document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE.toString(), "F01-123", organization);
                            logger.info("transaction1: document email: " + document.getCustomerElectronicMail());
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
                            logger.info("transaction2: Going to update document currency code");

                            OrganizationModel organization = session.organizations().getOrganizationByName("original");
                            DocumentModel document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE.toString(), "F01-123", organization);
                            document.setCustomerElectronicMail("new");
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
        DocumentModel documentFromCache = session.documents().getDocumentById(documentDBId, organization);
        DocumentModel documentFromDB = session.getProvider(DocumentProvider.class).getDocumentById(documentDBId, organization);

        logger.info("SECRET FROM DB : " + documentFromDB.getCustomerElectronicMail());
        logger.info("SECRET FROM CACHE : " + documentFromCache.getCustomerElectronicMail());

        Assert.assertEquals("new", documentFromDB.getCustomerElectronicMail());
        Assert.assertEquals("new", documentFromCache.getCustomerElectronicMail());
    }

    @Test
    public void removeOrganizationAttribute() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        OpenfactSession session = organizationManager.getSession();

        DocumentModel document1 = session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-12", organization);
        document1.setSingleAttribute("foo", "val1");

        DocumentModel document2 = session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-123", organization);
        document2.setSingleAttribute("foo", "val2");

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
                                DocumentModel document1 = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE.toString(), "F01-12", organization);
                                String attrVal = document1.getFirstAttribute("foo");

                                DocumentModel document2 = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE.toString(), "F01-123", organization);
                                String attrVal2 = document2.getFirstAttribute("foo");

                                // Wait until it's read in both threads
                                readAttrLatch.countDown();
                                readAttrLatch.await();

                                // KEYCLOAK-3296 : Remove user attribute in both threads
                                document1.removeAttribute("foo");

                                // KEYCLOAK-3494 : Set single attribute in both threads
                                document2.setSingleAttribute("foo", "bar");
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

        logger.info("removeDocumentAttribute: after thread join");

        commit();

        if (reference.get() != null) {
            Assert.fail("Exception happened in some of threads. Details: " + reference.get().getMessage());
        }
    }

}
