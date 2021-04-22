package com.individualcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Trigger.MainTrigger;

public class Mytraining {
	
	
	@Test
	public void method1() throws IOException {
		
		String name="trainingcase";
		
		MainTrigger mt = new MainTrigger();
		mt.runthis(name);
		
		
	}

}
