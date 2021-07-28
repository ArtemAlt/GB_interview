package errors;

public class Lorry extends Car implements Moveable, Stopable{
//class Lorry extends Car, Moveable, Stopable
// не поддерживается множественное наследование, нужна реализация всех методов
    @Override
    void open() {
        System.out.println("Lorry is opening");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stop");
    }
}
