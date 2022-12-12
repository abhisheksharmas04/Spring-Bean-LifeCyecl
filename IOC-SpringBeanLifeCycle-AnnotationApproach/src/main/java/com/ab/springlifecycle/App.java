package com.ab.springlifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ab.springlifecycle.beans.VoterVerifier;

public class App 
{
    public static void main( String[] args ){
        // create IOC container:
    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/ab/springlifecycle/cfg/applicationContext.xml");
    	
    	// get spring bean object:
    	VoterVerifier voter = ctx.getBean("voter", VoterVerifier.class);
    	
    	// invokes business method:
    	try {
			System.out.println(voter.checkVotingEligibility());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	// close the container
    	ctx.close();
    }
}
