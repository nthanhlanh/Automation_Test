package com.example.java_automation_framework;

import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasspathResource("features")
public class RunCucumberTest {
}