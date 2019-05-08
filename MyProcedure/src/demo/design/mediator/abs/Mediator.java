package demo.design.mediator.abs;

import demo.design.mediator.imp.Colleague;

public abstract class Mediator {
    public abstract void contact(String content,Colleague coll);
}
