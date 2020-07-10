package com.beta.backend.Models;

public class Hello {
    String hello;

    public Hello(String locale, String username){
        switch (locale){
            case "en":
                hello = "Hello, " + username;
                break;
            case "ru":
                hello = "Privet, " + username;
                break;
            case "pl":
                hello = "Cześć, " + username;
                break;
            case "fi":
                hello = "Terve, " + username;
                break;
            default:
                hello = "Hello, ";

        }
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
