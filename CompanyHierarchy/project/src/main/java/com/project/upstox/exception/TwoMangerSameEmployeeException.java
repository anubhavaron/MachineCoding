package com.project.upstox.exception;

public class TwoMangerSameEmployeeException extends Exception {

    private static final String msg = "TwoMangerSameEmployeeException";

    public TwoMangerSameEmployeeException() {
        super(msg);
    }
}
