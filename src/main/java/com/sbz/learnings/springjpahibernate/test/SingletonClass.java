package com.sbz.learnings.springjpahibernate.test;

public class SingletonClass {

    private static SingletonClass INSTANCE = null;

    private SingletonClass() {
    }

    public static synchronized SingletonClass getInstance() {
        if (INSTANCE == null) {
            return new SingletonClass();
        }
        return INSTANCE;
    }
}
