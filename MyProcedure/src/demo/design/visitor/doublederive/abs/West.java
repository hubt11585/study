package demo.design.visitor.doublederive.abs;

import demo.design.visitor.doublederive.imp.SubEast1;
import demo.design.visitor.doublederive.imp.SubEast2;

public abstract class West {
    public abstract void goWest1(SubEast1 east);

    public abstract void goWest2(SubEast2 east);
}
