package com.elton.app.criterioAceitacao.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = "classpath:com/elton/app/criterioAceitacao/cucumber",
tags = "~@skip", strict = false)
public class RunCakesTest {

}
