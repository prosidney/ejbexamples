package com.sidney.beans;

import javax.ejb.Stateless;

@Stateless(name="HelloBeanCustomName")
public class HelloBean implements HelloRemote {

  public String greet(String name) {
    return "Hello " + name;
  }
}