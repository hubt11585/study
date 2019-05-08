package demo.design.bridge.abs;

import demo.design.bridge.inf.Road;

public abstract class Local {
    public Road road ;// 路的接口
    public abstract void fromLocal();
}
