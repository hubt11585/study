package demo.design.prototype.deepcopy.imp;

public class Programmer implements Cloneable{
    private String name;//Ãû×Ö

    private  Address address;

    public Programmer(String name,Address address){
        this.name=name;
        this.address=address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {
        Programmer proto = (Programmer) super.clone();
        proto.address=(Address) address.clone();
        return proto;
    }
}
