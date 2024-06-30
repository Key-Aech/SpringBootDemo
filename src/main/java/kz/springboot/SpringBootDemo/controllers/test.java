package kz.springboot.SpringBootDemo.controllers;

public class test {

    int id = 1;
    String name = "No name";
    Double cash = 12000.5;

}

class test1 {

    public static void main(String[] args){

        test testcase = new test();

        testcase.id = 0;
        testcase.name = "Akmal";
        testcase.cash = 9999999.99;

        System.out.println(testcase.name);

    }

}
