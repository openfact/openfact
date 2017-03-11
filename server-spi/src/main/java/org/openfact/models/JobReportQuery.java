package org.openfact.models;

import java.util.Date;
import java.util.List;

public interface JobReportQuery {

    JobReportQuery jobName(String... jobName);

    JobReportQuery fromDate(Date fromDate);

    JobReportQuery toDate(Date toDate);

    JobReportQuery firstResult(int result);

    JobReportQuery maxResults(int results);

    List<AdminJobReport> getResultList();

}
