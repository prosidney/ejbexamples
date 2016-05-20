package com.sidney.timer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Singleton(name = "EveryMinuteEJB")
public class EveryMinuteEJB implements EveryMinuteEJBRemote {
	
	@Resource
    private TimerService timerSvc;

    @Timeout
    public void doStuff(Timer t) {
        try {
            doActualStuff(t);
        } catch (Exception e) {
            System.err.println("Error running task");
        }
        scheduleStuff();
    }

    private void doActualStuff(Timer t) {
        System.out.println("Doing Stuff " + t.getInfo());
    }

    @PostConstruct
    public void initialise() {
    	System.out.println("initialised");
        scheduleStuff();
    }

    private void scheduleStuff() {
        TimerConfig timerConfig = new TimerConfig();
        timerConfig.setInfo("some info");
		timerSvc.createSingleActionTimer(10000l, timerConfig); // 10000l means 10 seconds
    }

    public void stop() {
        for(Timer timer : timerSvc.getTimers()) {
            timer.cancel();
        }
    }
}
