package com.ghevi.utils;

public class ItWillNotBeScanned {

    // This package wont be scanned for component scanning from spring because it outside
    // of the project package. We can make spring scan it by writing in the projectManagementApplication:
    // @SpringBootApplication(scanBasePackages = {"com.ghevi.pma", "com.ghevi.utils"})
}
