package com.sidney.beans;

import javax.ejb.Remote;

@Remote
public interface HelloRemote {
	String greet(String name);
}