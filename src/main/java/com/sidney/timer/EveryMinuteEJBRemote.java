package com.sidney.timer;

import javax.ejb.Remote;
import javax.ejb.Timer;

@Remote
public interface EveryMinuteEJBRemote {
	public void doStuff(Timer t);
	public void stop();
}
