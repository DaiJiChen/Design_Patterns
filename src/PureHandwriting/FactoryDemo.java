package PureHandwriting;

interface Shape {
    public void whoAmI();
}

class Square implements Shape {
    @Override
    public void whoAmI() {
        System.out.println("This is a square");
    }
}

class Circle implements Shape {
    @Override
    public void whoAmI() {
        System.out.println("This is a circle");
    }
}

class ShapeFactory {
    public Shape getShape(String type) {
        switch (type) {
            case "Square":
                return new Square();
            case "Circle":
                return new Circle();
            default:
                return null;
        }
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape square = factory.getShape("Square");
        Shape circle = factory.getShape("Circle");

        square.whoAmI();
        circle.whoAmI();
    }
}
