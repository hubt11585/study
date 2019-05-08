package demo.design.decorator.abs;

import demo.design.decorator.inf.Person;

public abstract class Decorator implements Person{
    protected Person person;    //»À

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void eat(){
        person.eat();
    }
}
