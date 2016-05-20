package com.prosidney.tests;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sidney.beans.HelloRemote;
import com.sidney.timer.EveryMinuteEJBRemote;
import com.sidney.timer.TimerSessionBeanRemote;

public class EJBTester {

	private Context context;

	public static void main(String[] args) throws NamingException {
		
		EJBTester ejbTester = new EJBTester();

		//ejbTester.callTimerSessionBeanRemote();
		
		//ejbTester.callHelloRemote();
		
		ejbTester.callEveryMinuteEJBRemote();
	}
	
	public EJBTester() throws NamingException {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		props.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
		props.put("jboss.naming.client.ejb.context", true);
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		props.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", "false");
		
		context = new InitialContext(props);
	}
	
	public Object lookup(String jndiLookup) throws NamingException{
		return context.lookup(jndiLookup);
	}
	
	public void callTimerSessionBeanRemote() throws NamingException {
		TimerSessionBeanRemote hello = (TimerSessionBeanRemote) lookup("ejbexamples/TimerSessionBean!com.sidney.timer.TimerSessionBeanRemote");
		
		hello.createTimer(100);
	}
	
	public void callHelloRemote() throws NamingException {
		HelloRemote hello = (HelloRemote) lookup("ejbexamples/HelloBeanCustomName!com.sidney.beans.HelloRemote");
		
		System.out.println(hello.greet("World"));
	}
	
	public void callEveryMinuteEJBRemote() throws NamingException {
		EveryMinuteEJBRemote hello = (EveryMinuteEJBRemote) lookup("ejbexamples/EveryMinuteEJB!com.sidney.timer.EveryMinuteEJBRemote");
		
		hello.stop();
	}

}