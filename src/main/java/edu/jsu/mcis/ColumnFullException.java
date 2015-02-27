package edu.jsu.mcis;

public class ColumnFullException extends RuntimeException{    
    public ColumnFullException(String error){
        super(error);
    }
}