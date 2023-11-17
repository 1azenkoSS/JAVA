package org.example.data.exceprion;

public class ProductQuantityUnavailableException extends Exception{
    public ProductQuantityUnavailableException(String errorMessage){
        super(errorMessage);
    }
}