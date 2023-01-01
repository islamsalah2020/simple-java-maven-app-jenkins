package com.mycompany.app;
import java.lang.Thread;  
import java.io.*;  

/**
 * Hello world!
 */
public class App
{

    private final String message = "Hello World!";

    public App() {}

    public static void main(String[] args) {
        
        System.out.println(new App().getMessage());
    }
    
    
    
    private final String getMessage() {
        try {  
        for (int j = 0; j < 5; j++)  
        {  
  
        // The main thread sleeps for the 1000 milliseconds, which is 1 sec  
        // whenever the loop runs  
        Thread.sleep(100);  
  
        // displaying the value of the variable  
        System.out.println(j);  
        }  
        }  
        catch (Exception expn)   
        {  
        // catching the exception  
        System.out.println(expn);  
        }
        return message;
    }
    
    

}
