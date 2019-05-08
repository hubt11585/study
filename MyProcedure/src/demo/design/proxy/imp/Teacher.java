package demo.design.proxy.imp;

import demo.design.proxy.inf.Person;

public class Teacher implements Person {
    Person Person = null;
    Teacher(Person Person){
        this.Person = Person;
    }

    @Override
    public void eat() {
        Person.eat();
    }
}
