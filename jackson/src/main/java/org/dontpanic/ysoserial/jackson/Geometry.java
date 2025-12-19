package org.dontpanic.ysoserial.jackson;

public class Geometry {

    private Object shape;

    public Geometry() {
    }

    public Object getShape() {
        return shape;
    }

    public void setShape(Object shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "A geometry with shape: " + shape;
    }
}
