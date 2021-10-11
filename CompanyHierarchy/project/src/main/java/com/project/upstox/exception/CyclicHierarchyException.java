package com.project.upstox.exception;

public class CyclicHierarchyException extends Exception {

    private static final String msg = "CyclicHierarchyException";

    public CyclicHierarchyException() {
        super(msg);
    }

}
