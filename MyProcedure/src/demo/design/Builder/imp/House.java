package demo.design.Builder.imp;

public class House {
    private int area; //面积
    private int sleeping; //房间
    private int toliet; //厕所
    private int carNum; //车库

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getSleeping() {
        return sleeping;
    }

    public void setSleeping(int sleeping) {
        this.sleeping = sleeping;
    }

    public int getToliet() {
        return toliet;
    }

    public void setToliet(int toliet) {
        this.toliet = toliet;
    }

    public int getCarNum() {
        return carNum;
    }

    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }
}
