package com.mycompany.app;

/**
 * Hello world!
 */
public class App
{

    private final String message = "Hello World!";

    public App() {}

    public static void main(String[] args) {
        wait(1000);
        System.out.println(new App().getMessage());
    }
    
    
    
    private final String getMessage() {
        for ( let counter = 1; counter <= 1000; counter++ ) {
        System.out.println(`The number is ${counter}`); 
        }
        return message;
    }

}
