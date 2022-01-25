package com.sbz.learnings.springjpahibernate.test;

public final class MutableClass {

    private final String someField;

    public MutableClass(String someField) {
        this.someField = someField;
    }

    public String getSomeField() {
        return someField;
    }
}
