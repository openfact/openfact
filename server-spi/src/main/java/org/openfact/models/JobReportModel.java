/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
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
 *******************************************************************************/
package org.openfact.models;

import java.util.Map;

public interface JobReportModel {

    String getId();

    String getJobName();

    void setJobName(String jobName);

    long getIncrementFilteredCount();

    void setIncrementFilteredCount(long value);

    long getIncrementErrorCount();

    void setIncrementErrorCount(long value);

    long getIncrementReadCount();

    void setIncrementWriteCount(long count);

    long getStartTime();

    void setStartTime(long startTime);

    long getEndTime();

    void setEndTime(long endTime);

    long getDuration();

    void setDuration(long value);

    long getFilteredCount();

    void setFilteredCount(long value);

    long getErrorCount();

    void setErrorCount(long value);

    long getReadCount();

    void setReadCount(long value);

    long getWriteCount();

    void setWriteCount(long value);

    Map<String, String> getAttributes();

    void addAttribute(String name, String value);

}
