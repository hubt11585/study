package demo.design.AbstractFactory.imp;

public class TestShaobingStore {
    public static void main(String[] args){
        //在广州开一个烧饼店
        HZShaobingStore gzStore = new HZShaobingStore();
        //售出一个洋葱烧饼
        gzStore.createShaobing("greens");
        gzStore.createShaobing("greens");
    }
}
