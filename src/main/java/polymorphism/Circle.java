package polymorphism;

public class Circle extends Shape {

    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius=radius;
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }
    public int getRadius(){
        return this.radius;
    }
}
