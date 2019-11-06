package demo.knowledgepoints.serializable;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Box implements Serializable {

    public static Box box = new Box();

    public Box(){}

    public Box(String height,String width){
        this.height = height;
        this.width = width;
    }

    public static Box getInstance() {
        if(box == null){
            box = new Box("20","10");
        }
        return box;
    }

    private String width;
    private String height;

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    private Object readResolve() throws ObjectStreamException {
        return Box.box;
    }
}
