package demo.knowledgepoints.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class BoxTmp implements Externalizable {
    public BoxTmp(){
        System.out.println("调用构造Box方法");
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeChars(width+","+width);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        String str = in.readLine();
        this.width = str.split(",")[0];
        this.height = str.split(",")[1];
    }

    @Override
    public String toString() {
        return "BoxTmp{" +
                "width='" + width + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
