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
    
    public static void wait(int ms)
    {
    try
    {
        Thread.sleep(ms);
    }
    catch(InterruptedException ex)
    {
        Thread.currentThread().interrupt();
    }
    }
    
    private final String getMessage() {

        return message;
    }

}
