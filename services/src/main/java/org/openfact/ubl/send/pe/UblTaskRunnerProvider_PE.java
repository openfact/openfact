package org.openfact.ubl.send.pe;

import java.io.File;

import javax.sql.DataSource;

import org.easybatch.core.job.Job;
import org.easybatch.core.job.JobBuilder;
import org.easybatch.core.job.JobExecutor;
import org.easybatch.core.job.JobReport;
import org.openfact.models.OpenfactSession;
import org.openfact.ubl.send.UblTaskRunnerProvider;

import static org.easybatch.core.job.JobBuilder.aNewJob;

public class UblTaskRunnerProvider_PE implements UblTaskRunnerProvider {

    protected OpenfactSession session;

    public UblTaskRunnerProvider_PE(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
    }

    @Override
    public void exececuteTask() {
        System.out.println("UblTaskRunnerProvider_PE");
        sendInvoices();
        sendCreditNotes();
        sendDebitNotes();
    }

    protected void sendInvoices() {
        //Job job = JobBuilder.aNewJob().named("myName").build();

        // Execute the job
        /*JobExecutor jobExecutor = new JobExecutor();
        JobReport jobReport = jobExecutor.execute(job);
        jobExecutor.shutdown();*/
    }

    protected void sendCreditNotes() {

    }

    protected void sendDebitNotes() {

    }

}
