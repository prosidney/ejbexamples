package com.sidney.timer;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;

@Stateless(name = "TimerSessionBean")
public class TimerSessionBean implements TimerSessionBeanRemote {

   @Resource
   private SessionContext context;

   public void createTimer(long duration) {
      context.getTimerService().createTimer(duration, "Hello World!");
   }

   @Timeout
   public void timeOutHandler(Timer timer){
      System.out.println("timeoutHandler : " + timer.getInfo());        
      timer.cancel();
   }
}