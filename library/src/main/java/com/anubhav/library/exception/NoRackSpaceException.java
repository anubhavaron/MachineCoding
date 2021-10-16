package com.anubhav.library.exception;

public class NoRackSpaceException extends Exception{

    private static final String msg = "BookCopies > AvailableRack Space : NoRackSpaceException ";

    public NoRackSpaceException() {
        super(msg);
    }
}
