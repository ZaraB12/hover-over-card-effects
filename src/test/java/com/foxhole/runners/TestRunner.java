package com.foxhole.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
      features =  "src/test/resources/features",
        glue = "com/foxhole/step_definitions",
        dryRun = false,
        tags = "@foxhole",
        publish = true
)
public class TestRunner {


}
