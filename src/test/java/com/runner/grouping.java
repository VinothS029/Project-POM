package com.runner;

import org.testng.annotations.Test;

public class grouping {
	
	@Test(groups = {"bikes","cars"})
	public void honda() {
		System.out.println("Cbr250");
	}
	@Test(groups = {"bikes","machines"})
	public void bajaj() {
		System.out.println("Pulsar150");
	}
	
	@Test(groups = {"cars","machines"})
	public void chevy() {
		System.out.println("Camaro");
	}
	@Test(groups = "cars")
	public void dodge() {
		System.out.println("ChallengerSrt");
	}
	@Test(groups = {"machines","bikes"})
	public void drillingmachine() {
		System.out.println("Driller");
	}
	@Test(groups = "machines")
	public void washingmachine() {
		System.out.println("Washing machine");
	}

}
