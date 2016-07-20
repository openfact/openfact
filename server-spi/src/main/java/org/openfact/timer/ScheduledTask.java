package org.openfact.timer;

import org.openfact.models.RepeidSession;

public interface ScheduledTask {

    public void run(RepeidSession session);

}
