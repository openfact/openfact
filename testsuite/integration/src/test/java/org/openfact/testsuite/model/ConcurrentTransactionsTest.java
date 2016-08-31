package org.openfact.testsuite.model;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.jboss.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactModelUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.DocumentType;

public class ConcurrentTransactionsTest extends AbstractModelTest {

    private static final Logger logger = Logger.getLogger(ConcurrentTransactionsTest.class);

    @Test
    public void removeInvoiceAttribute() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        organization.setAdditionalAccountId(organization.addSimpleDocument(DocumentType.ADDITIONAL_IDENTIFICATION_ID, "RUC", "05"));
        commit();

        OpenfactSession session = organizationManager.getSession();

        InvoiceModel invoice = session.invoices().addInvoice(organization, 1, 1);
        invoice.setSingleAttribute("foo", "val1");

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
                                InvoiceModel john = session.invoices().getInvoiceBySeriesAndNumber(1, 1, organization);
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

        logger.info("removeInvoiceAttribute: after thread join");

        commit();

        if (reference.get() != null) {
            Assert.fail("Exception happened in some of threads. Details: " + reference.get().getMessage());
        }
    }

}
