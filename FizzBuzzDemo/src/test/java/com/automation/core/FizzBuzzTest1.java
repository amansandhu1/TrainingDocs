package com.automation.core;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FizzBuzzTest1 {

	FizzBuzz fizzBuzz = new FizzBuzz();
	int number;

	@Test
	public void returnsNumberForNumberNotDivisibleByThreeAndFive() {
		number = 4;
		Assert.assertEquals(fizzBuzz.calculate(number), String.valueOf(number));
	}

	@Test
	public void returnFizzForNumberDivisibleByThree() {
		number = 3;
		Assert.assertEquals(fizzBuzz.calculate(number), "Fizz");
	}

	@Test
	public void returnBuzzForNumberDivisibleByFive() {
		number = 5;
		Assert.assertEquals(fizzBuzz.calculate(number), "Buzz");
	}

	@Test
	public void returnsFizzBuzzForNumberDivisibleByThreeAndFive() {
		number = 15;
		Assert.assertEquals(fizzBuzz.calculate(number), "FizzBuzz");
	}
}
