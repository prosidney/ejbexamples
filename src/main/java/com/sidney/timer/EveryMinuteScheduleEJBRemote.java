package com.sidney.timer;

import javax.ejb.Remote;
import javax.ejb.Timer;

@Remote
public interface EveryMinuteScheduleEJBRemote {
	public void oneMinuteHasPassed();
}
