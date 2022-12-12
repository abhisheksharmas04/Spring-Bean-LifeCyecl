package com.ab.springlifecycle.beans;

import java.util.Date;

public class VoterVerifier {
	
	private String name;
	private float age;
	private Date verificationDate;
	
	public VoterVerifier() {
		System.out.println("0 :: param constructor VoterVerifier.VoterVerifier()");
	}
	
	// Setter methdos for setter injection
	public void setName(String name) {
		System.out.println("VoterVerifier.setName()");
		this.name = name;
	}
	
	public void setAge(float age) {
		System.out.println("VoterVerifier.setAge()");
		this.age = age;
	}
	
	// business method:
	public String checkVotingEligibility() {
		if(age<18)
			return "MR/Miss/Mrs. " + name +" you are not elibile for voting wait " + (18-age) +" to cast your vote";
		else
			return "MR/Miss/Mrs. " + name +" you are elibile for voting don't wait varification date: " + verificationDate ;
	}
	
	//-- init-life cycle method
	public void myInit() {
		System.out.println("VoterVerifier.myInit()(Custome init Method)");
		
		// initilization the value which are not taking particapting in dependency injection
		verificationDate = new Date();
		
		// validation
		if (name == null || age <= 0) {
			throw new IllegalArgumentException("Invalid User Input");
		}
		
	}
	/*for init life cycle method signature should be public void only*/
	
	//- destroyed life cycle method
	public void myDestroy() {
		System.out.println("VoterVerifier.myDestroy()");
		name = null;
		age = 0;
		verificationDate = null;
	}
	
}
