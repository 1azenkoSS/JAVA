package org.example.data.exceprion;

public class ProductDoesntExistException extends Exception{
    public ProductDoesntExistException(String errorMessage){
        super(errorMessage);
    }
}
