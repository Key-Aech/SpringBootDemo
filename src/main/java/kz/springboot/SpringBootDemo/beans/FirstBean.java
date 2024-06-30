package kz.springboot.SpringBootDemo.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
public class FirstBean {

    private String name;
    private int price;
    private int amount;


     FirstBean(){

        System.out.println(("Using Default Constructor of First Bean Class"));
        this.name = "No Name";
        this.price = 0;
        this.amount = 0;

    }

    public FirstBean(String name, int price, int amount){

        System.out.println(("Using Default Constructor of First Bean Class"));
        this.name = name;
        this.price = price;
        this.amount = amount;

    }

    public String getText(){
        return this.name + " " + this.price + " " + this.amount;
    }



}
