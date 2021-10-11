package com.coding.library.exception;

public class NoRackAvailableException extends Exception{

    private static final String msg = "NoRackAvailableException";

    public NoRackAvailableException() {
        super(msg);
    }
}
