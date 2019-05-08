package demo.design.mediator.imp;

import demo.design.mediator.abs.Mediator;

public class Colleague {
    protected String name;
    protected Mediator mediator;

    public Colleague(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
