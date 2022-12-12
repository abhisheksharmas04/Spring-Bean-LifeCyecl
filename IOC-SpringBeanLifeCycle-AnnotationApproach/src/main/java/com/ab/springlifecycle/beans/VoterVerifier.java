package com.ab.springlifecycle.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("voter")
public class VoterVerifier {

	@Value("${voter.name}")
	private String name;
	
	@Value("${voter.age}")
	private float age;
	
	private Date verificationDate;

	public VoterVerifier() {
		System.out.println("0 :: param constructor VoterVerifier.VoterVerifier()");
	}

	// business method:
	public String checkVotingEligibility() {
		if (age < 18)
			return "MR/Miss/Mrs. " + name + " you are not elibile for voting wait " + (18 - age) + " to cast your vote";
		else
			return "MR/Miss/Mrs. " + name + " you are elibile for voting don't wait varification date: "
					+ verificationDate;
	}

	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("VoterVerifier.destroy() Custome destroy method through Annotation");
		name = null;
		age = 0;
		verificationDate = null;

	}

	@PostConstruct /* from Java 11 this annotation is comes in a seprate package*/
	public void myInit() throws Exception {
		System.out.println("VoterVerifier.afterPropertiesSet() Custome init method through Annotation");

		// Initialization the value which are not taking particapting in dependency
		// injection
		verificationDate = new Date();

		// validation
		if (name == null || age <= 0) {
			throw new IllegalArgumentException("Invalid User Input");
		}

	}
	/*
	 	from java 9 onwards to use @PostConstruct use this jar
	  <dependency> <groupId>javax.annotation</groupId>
	  <artifactId>javax.annotation-api</artifactId> <version>1.3.2</version>
	  </dependency>
	  
	 */

}
