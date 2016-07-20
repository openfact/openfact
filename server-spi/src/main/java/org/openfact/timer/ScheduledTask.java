package org.openfact.timer;

import org.openfact.models.OpenfactSession;

public interface ScheduledTask {

    public void run(OpenfactSession session);

}
