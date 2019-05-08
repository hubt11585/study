package demo.design.interpreter.abs;

import demo.design.interpreter.imp.Context;

public abstract class Expression {

    /**
     * �Ի���Ϊ׼�����������͸������κ�һ�����ʽ
     */
    public abstract boolean interpret(Context ctx);
    /**
     * �����������ʽ�ڽṹ���Ƿ���ͬ
     */
    public abstract boolean equals(Object obj);
    /**
     * ���ر��ʽ��hash code
     */
    public abstract int hashCode();
    /**
     * �����ʽת�����ַ���
     */
    public abstract String toString();
}
