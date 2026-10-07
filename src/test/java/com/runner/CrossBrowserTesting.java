package com.runner;

import org.testng.annotations.Test;

import com.reusableclass.BaseClass;

public class CrossBrowserTesting extends BaseClass {
	@Test
	private void chrome() {
		launchBrowser("Chrome");
		launchUrl("https://www.naukri.com/");
		System.out.println("Browser Id :"+Thread.currentThread().getId());
	}
	@Test
	private void edge() {
		launchBrowser("Edge");
		launchUrl("https://www.naukri.com/");
		System.out.println("Browser Id :"+Thread.currentThread().getId());
	}
	@Test
	private void firefox() {
		launchBrowser("Firefox");
		launchUrl("https://www.naukri.com/");
		System.out.println("Browser Id :"+Thread.currentThread().getId());
	}

}
