package polymorphism;

public class Triangle extends Shape{

    private int z;

    public Triangle(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    @Override
    public double area() {
        int side1 = Math.abs(getX()-getZ());
        int side2 = Math.abs(getX()-getY());
        int side3 = Math.abs(getZ()-getY());
        double halfPerimeter = (side1+side2+side3)*0.5;
        return Math.sqrt(halfPerimeter*(halfPerimeter-side1)*(halfPerimeter-side2)*(halfPerimeter-side3));
    }
}
