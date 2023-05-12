package com.company;

import com.company.somePackage.SomeInterface;

public class TestClass {
    @AutoInjectable
    private SomeInterface someInterface;

    public String doSomething ( ) {
        return someInterface.doSomething ( );
    }
}
