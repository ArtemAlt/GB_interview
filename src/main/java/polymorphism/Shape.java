package polymorphism;

import java.util.Arrays;

public abstract class Shape {
    private final int x;
    private final int y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract double area();

    public double sumAreas (Shape ... shapes){
        return Arrays.stream(shapes)
                .map(Shape::area)
                .reduce(0.0,Double::sum);
    }


}
