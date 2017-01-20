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

package org.openfact.testsuite.performance;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactTransaction;
import org.openfact.models.OrganizationModel;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.OpenfactApplication;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public class BaseJMeterPerformanceTest extends AbstractJavaSamplerClient {


    private static FutureTask<OpenfactSessionFactory> factoryProvider = new FutureTask<OpenfactSessionFactory>(new Callable() {

        @Override
        public OpenfactSessionFactory call() throws Exception {
            OpenfactSessionFactory factory = OpenfactApplication.createSessionFactory();

            // TODO: Workaround due to bouncycastle classpath issues. Should be fixed properly
            // new ApplianceBootstrap().bootstrap(factory, "/openfact");
            bootstrapAdminOrganization(factory, "/openfact");

            return factory;
        }

        private void bootstrapAdminOrganization(OpenfactSessionFactory factory, String contextPath) {
            OpenfactSession openfactSession = factory.create();
            openfactSession.getTransactionManager().begin();

            try {
                String adminOrganizationName = Config.getAdminOrganization();
                if (openfactSession.organizations().getOrganization(adminOrganizationName) == null) {

                    OrganizationManager manager = new OrganizationManager(openfactSession);
                    manager.setContextPath(contextPath);
                    OrganizationModel organization = manager.createOrganization(adminOrganizationName, adminOrganizationName);
                    organization.setName(adminOrganizationName);
                    organization.setEnabled(true);
                }

                openfactSession.getTransactionManager().commit();
            } finally {
                openfactSession.close();
            }
        }

    });
    private static AtomicInteger counter = new AtomicInteger();

    private OpenfactSessionFactory factory;
    // private OpenfactSession session;
    private Worker worker;
    private boolean setupSuccess = false;


    // Executed once per JMeter thread
    @Override
    public void setupTest(JavaSamplerContext context) {
        super.setupTest(context);

        worker = getWorker();

        factory = getFactory();
        getLogger().info("Retrieved factory: " + factory);
        OpenfactSession session = factory.create();
        OpenfactTransaction transaction = session.getTransactionManager();
        transaction.begin();

        int workerId = counter.getAndIncrement();
        try {
            worker.setup(workerId, session);
            setupSuccess = true;
        } finally {
            if (setupSuccess) {
                transaction.commit();
            } else {
                transaction.rollback();
            }
            session.close();
        }
    }

    private static OpenfactSessionFactory getFactory() {
        factoryProvider.run();
        try {
            return factoryProvider.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private Worker getWorker() {
        String workerClass = System.getProperty("openfact.perf.workerClass");
        if (workerClass == null) {
            throw new IllegalArgumentException("System property openfact.perf.workerClass needs to be provided");
        }

        try {
            Class workerClazz = Class.forName(workerClass);
            return (Worker)workerClazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult result = new SampleResult();
        result.sampleStart();

        if (!setupSuccess) {
            getLogger().error("setupTest didn't executed successfully. Skipping");
            result.setResponseCode("500");
            result.sampleEnd();
            result.setSuccessful(true);
            return result;
        }

        OpenfactSession session = factory.create();
        OpenfactTransaction transaction = session.getTransactionManager();
        try {
            transaction.begin();

            worker.run(result, session);

            result.setResponseCodeOK();
            transaction.commit();
        } catch (Exception e) {
            getLogger().error("Error during worker processing", e);
            result.setResponseCode("500");
            transaction.rollback();
        } finally {
            result.sampleEnd();
            result.setSuccessful(true);
            session.close();
        }

        return result;
    }


    // Executed once per JMeter thread
    @Override
    public void teardownTest(JavaSamplerContext context) {
        super.teardownTest(context);

        if (worker != null) {
            worker.tearDown();
        }

        // TODO: Assumption is that tearDownTest is executed for each setupTest. Verify if it's always true...
        if (counter.decrementAndGet() == 0) {
            if (factory != null) {
                factory.close();
            }
        }
    }
}
