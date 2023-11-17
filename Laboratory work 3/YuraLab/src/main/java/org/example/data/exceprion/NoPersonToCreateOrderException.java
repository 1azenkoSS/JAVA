package org.example.data.exceprion;

public class NoPersonToCreateOrderException extends Exception{
    public NoPersonToCreateOrderException(String errorMessage){
        super(errorMessage);
    }
}
