package com.nhsPatient.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
      features =  "src/test/resources/features",
        glue = "com/nhsPatient/step_definitions",
        dryRun = false,
        tags = "@foxhole"
)
public class TestRunner {


}
