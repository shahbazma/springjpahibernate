package com.sbz.learnings.springjpahibernate.exception;

public class NoBookFoundException extends RuntimeException{

    public NoBookFoundException(String message) {
        super(message);
    }
}
