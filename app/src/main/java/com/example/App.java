/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.example;




public class App {
    public void getGreeting() {
        LoginTestCases tests = new LoginTestCases();
        tests.testCase01();
        tests.testCase_02();
        tests.testCase_03();
        tests.testCase_04();

        tests.closeWindow();
        
    }

    public void runDropdown(){
        DropdownTest dd = new DropdownTest();
        dd.dropBrowserLaunch();
        dd.dropdown();
        dd.closeWindow();
    }

    public static void main(String[] args) {
        new App().getGreeting();
        new App().runDropdown();

    }
}
