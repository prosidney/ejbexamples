package com.sidney.timer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.TimerService;

import com.sidney.beans.HelloRemote;

@Singleton(name = "EveryMinuteScheduleEJB")
public class EveryMinuteScheduleEJB implements EveryMinuteScheduleEJBRemote {
	
	@Resource
    private TimerService timerSvc;
	
	private HelloRemote helloRemote;

    @Timeout
    @Schedule(dayOfMonth="*", month="*", year="*", second="0", minute="*", hour="*")
    public void oneMinuteHasPassed() {
    	System.out.println("*********One Minute has passed***************");
    	sayHello();
    	System.out.println("*********************************************");
    }

    private void sayHello() {
        //System.out.println("Hello");
    	System.out.println(helloRemote.greet(this.getClass().getSimpleName()));
    }

    @PostConstruct
    public void initialise() {
    	System.out.println("EveryMinuteScheduleEJB has been initialized");
    }
}
