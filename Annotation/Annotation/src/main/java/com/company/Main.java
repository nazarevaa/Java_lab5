package com.company;

import com.company.somePackage.SomeInterface;

import java.io.IOException;

public class Main {
    public static void main ( String[] args ) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IOException {
        TestClass cls = (new Injector ()).inject ( new TestClass () );
        System.out.println ( cls.doSomething ());

    }
}
