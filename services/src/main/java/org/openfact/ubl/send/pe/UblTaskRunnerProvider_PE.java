package org.openfact.ubl.send.pe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.easybatch.core.filter.HeaderRecordFilter;
import org.easybatch.core.job.Job;
import org.easybatch.core.job.JobBuilder;
import org.easybatch.core.job.JobExecutor;
import org.easybatch.core.job.JobMetrics;
import org.easybatch.core.job.JobParameters;
import org.easybatch.core.job.JobReport;
import org.easybatch.core.processor.RecordProcessor;
import org.easybatch.core.reader.IterableRecordReader;
import org.easybatch.core.record.Batch;
import org.easybatch.core.record.Record;
import org.easybatch.core.writer.RecordWriter;
import org.openfact.common.DateUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.JobReportModel;
import org.openfact.ubl.pe.constants.CodigoTipoDocumento;
import org.openfact.ubl.send.UblTaskRunnerProvider;
import org.openfact.ubl.send.UblTemplateProvider;

public class UblTaskRunnerProvider_PE implements UblTaskRunnerProvider {

	protected OpenfactSession session;

	public UblTaskRunnerProvider_PE(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {
	}

	@Override
	public void exececuteTask(OrganizationModel organization) {
		UblTaskRunnerReader ublTaskRunnerReader = new UblTaskRunnerReader(session, organization);
		sendInvoices(organization, ublTaskRunnerReader);
		sendCreditNotes(organization, ublTaskRunnerReader);
		sendDebitNotes(organization, ublTaskRunnerReader);
	}

	protected void sendInvoices(OrganizationModel organization, UblTaskRunnerReader ublTaskRunnerReader) {
		List<InvoiceModel> result = ublTaskRunnerReader.getInvoiceReader(false);
		List<InvoiceModel> invoices = new ArrayList<>();
		List<InvoiceModel> summary = new ArrayList<>();
		for (InvoiceModel invoice : result) {
			if (CodigoTipoDocumento.BOLETA.getCodigo().equals(invoice.getInvoiceTypeCode())) {
				summary.add(invoice);
			} else {
				invoices.add(invoice);
			}
		}
		sendInvoice(organization, invoices);
		sendSummary(organization, summary);
	}

	protected void sendSummary(OrganizationModel organization, List<InvoiceModel> summary) {
		if (summary.size() > 0) {
			String jobName = generateJobName();
			JobReportModel jobReportModel = session.jobReport().createJobReport(organization, jobName,
					"INVOICE SUMMARY");
			Job job = JobBuilder.aNewJob().named(jobName).reader(new IterableRecordReader(summary))
					.filter(new HeaderRecordFilter()).writer(new SummaryRecordWriter(session, organization)).build();
			JobExecutor jobExecutor = new JobExecutor();
			JobReport jobReport = jobExecutor.execute(job);
			jobExecutor.shutdown();
			UpdateJobReportModel(jobReportModel, jobReport);
		}

	}

	protected void sendInvoice(OrganizationModel organization, List<InvoiceModel> invoices) {
		if (invoices.size() > 0) {
			String jobName = generateJobName();
			JobReportModel jobReportModel = session.jobReport().createJobReport(organization, jobName, "INVOICE");
			Job job = JobBuilder.aNewJob().named(jobName).reader(new IterableRecordReader(invoices))
					.filter(new HeaderRecordFilter()).processor(new InvoiceProcessor(session, organization)).build();
			JobExecutor jobExecutor = new JobExecutor();
			JobReport jobReport = jobExecutor.execute(job);
			jobExecutor.shutdown();
			UpdateJobReportModel(jobReportModel, jobReport);
		}
	}

	protected void sendCreditNotes(OrganizationModel organization, UblTaskRunnerReader ublTaskRunnerReader) {
		List<CreditNoteModel> creditNotes = ublTaskRunnerReader.getCreditNoteReader(false);
		if (creditNotes.size() > 0) {
			String jobName = generateJobName();
			JobReportModel jobReportModel = session.jobReport().createJobReport(organization, jobName, "CREDIT NOTE");
			Job job = JobBuilder.aNewJob().named(jobName).reader(new IterableRecordReader(creditNotes))
					.filter(new HeaderRecordFilter()).processor(new CreditNoteProcessor(session, organization)).build();
			JobExecutor jobExecutor = new JobExecutor();
			JobReport jobReport = jobExecutor.execute(job);
			jobExecutor.shutdown();
			UpdateJobReportModel(jobReportModel, jobReport);
		}
	}

	protected void sendDebitNotes(OrganizationModel organization, UblTaskRunnerReader ublTaskRunnerReader) {
		List<DebitNoteModel> debitNotes = ublTaskRunnerReader.getDebitNoteReader(false);
		if (debitNotes.size() > 0) {
			String jobName = generateJobName();
			JobReportModel jobReportModel = session.jobReport().createJobReport(organization, jobName, "DEBIT NOTE");
			Job job = JobBuilder.aNewJob().named(jobName).reader(new IterableRecordReader(debitNotes))
					.filter(new HeaderRecordFilter()).processor(new DebitNoteProcessor(session, organization)).build();
			JobExecutor jobExecutor = new JobExecutor();
			JobReport jobReport = jobExecutor.execute(job);
			jobExecutor.shutdown();
			UpdateJobReportModel(jobReportModel, jobReport);
		}
	}

	private String generateJobName() {
		return UUID.randomUUID().toString();
	}

	private void UpdateJobReportModel(JobReportModel jobReportModel, JobReport jobReport) {
		/*
		 * Job status
		 */
		jobReportModel.setStatus(jobReport.getStatus().name());

		/*
		 * Job parameters
		 */
		JobParameters parameters = jobReport.getParameters();
		jobReportModel.setBatchSize(parameters.getBatchSize());
		jobReportModel.setErrorThreshold(parameters.getErrorThreshold());
		jobReportModel.setJmxMonitoring(parameters.isJmxMonitoring());

		/*
		 * Job metrics
		 */
		JobMetrics metrics = jobReport.getMetrics();
		jobReportModel.setStartTime(DateUtils.getDateTimeFromTimestamp(metrics.getStartTime()));
		jobReportModel.setEndTime(DateUtils.getDateTimeFromTimestamp(metrics.getEndTime()));
		jobReportModel.setDuration(DateUtils.getDateTimeFromTimestamp(metrics.getDuration()));
		jobReportModel.setReadCount(metrics.getReadCount());

		jobReportModel.setWriteCount(metrics.getWriteCount());
		jobReportModel.setFilteredCount(metrics.getFilteredCount());
		jobReportModel.setErrorCount(metrics.getErrorCount());
	}

	static class InvoiceProcessor implements RecordProcessor<Record<InvoiceModel>, Record<InvoiceModel>> {
		private OpenfactSession session;
		private OrganizationModel organization;

		public InvoiceProcessor(OpenfactSession session, OrganizationModel organization) {
			this.organization = organization;
			this.session = session;
		}

		private UblTemplateProvider getUblTemplateProvider(OrganizationModel organization) {
			return session.getProvider(UblTemplateProvider.class, organization.getDefaultUblLocale())
					.setOrganization(organization);
		}

		@Override
		public Record<InvoiceModel> processRecord(Record<InvoiceModel> record) throws Exception {
			InvoiceModel invoice = record.getPayload();
			getUblTemplateProvider(organization).sendInvoice(Arrays.asList(invoice));
			return record;
		}
	}

	static class CreditNoteProcessor implements RecordProcessor<Record<CreditNoteModel>, Record<CreditNoteModel>> {
		private OpenfactSession session;
		private OrganizationModel organization;

		public CreditNoteProcessor(OpenfactSession session, OrganizationModel organization) {
			this.organization = organization;
			this.session = session;
		}

		private UblTemplateProvider getUblTemplateProvider(OrganizationModel organization) {
			return session.getProvider(UblTemplateProvider.class, organization.getDefaultUblLocale())
					.setOrganization(organization);
		}

		@Override
		public Record<CreditNoteModel> processRecord(Record<CreditNoteModel> record) throws Exception {
			CreditNoteModel creditNote = record.getPayload();
			getUblTemplateProvider(organization).sendCreditNote(creditNote);
			return record;
		}
	}

	static class DebitNoteProcessor implements RecordProcessor<Record<DebitNoteModel>, Record<DebitNoteModel>> {
		private OpenfactSession session;
		private OrganizationModel organization;

		public DebitNoteProcessor(OpenfactSession session, OrganizationModel organization) {
			this.organization = organization;
			this.session = session;
		}

		private UblTemplateProvider getUblTemplateProvider(OrganizationModel organization) {
			return session.getProvider(UblTemplateProvider.class, organization.getDefaultUblLocale())
					.setOrganization(organization);
		}

		@Override
		public Record<DebitNoteModel> processRecord(Record<DebitNoteModel> record) throws Exception {
			DebitNoteModel debitNote = record.getPayload();
			getUblTemplateProvider(organization).sendDebitNote(debitNote);
			return record;
		}
	}

	static class SummaryRecordWriter implements RecordWriter {
		private OpenfactSession session;
		private OrganizationModel organization;

		public SummaryRecordWriter(OpenfactSession session, OrganizationModel organization) {
			this.organization = organization;
			this.session = session;
		}

		private UblTemplateProvider getUblTemplateProvider(OrganizationModel organization) {
			return session.getProvider(UblTemplateProvider.class, organization.getDefaultUblLocale())
					.setOrganization(organization);
		}

		@Override
		public void open() throws Exception {

		}

		@Override
		public void writeRecords(Batch batch) throws Exception {
			List<InvoiceModel> summary = new ArrayList<>();
			for (Iterator<Record> iterator = batch.iterator(); iterator.hasNext();) {
				Record<InvoiceModel> record = iterator.next();
				summary.add(record.getPayload());
			}
			getUblTemplateProvider(organization).sendInvoice(summary);

		}

		@Override
		public void close() throws Exception {

		}
	}

}
