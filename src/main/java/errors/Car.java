package errors;


public abstract class Car {
    //    public class Car если у нас есть абстрактный метод то и клас должен быть абстрактным
    private Engine engine;
    // нет реализации класса Engine
    //public Engine engine; у нас есть get\set на это поле, нужно сделать приватным
//    лучше было сделать не класс, а интерфейс, что позволит использовать различные реализации Engine
    private String color;
    private String name;

    protected void start() {
        System.out.println("Car starting");
    }

    abstract void open();
    //    наверное лучше вынести в интерфейс

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
