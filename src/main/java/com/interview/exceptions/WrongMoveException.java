package com.interview.exceptions;

public class WrongMoveException extends Exception{
    public WrongMoveException(){}
    public WrongMoveException(String message){
        super(message);
    }
}
