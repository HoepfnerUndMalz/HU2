package se1.hu2.a2;
import java.util.ArrayList;
import java.util.List;

public class Figurenverwalter {


    static ArrayList<Figure> figuresList = new ArrayList<>();

    public static void main(String[] args) {

        Circle Kreis = new Circle(3);
        Rectangle Quadrat = new Rectangle(4, 4);
        Rectangle Rechteck1 = new Rectangle(2, 5);
        Rectangle Rechteck2 = new Rectangle(2, 5);

        figuresList.add(Kreis);
        figuresList.add(Quadrat);
        figuresList.add(Rechteck1);
        figuresList.add(Rechteck2);
        Rechteck2.scale(2);

        for (int i = 0; i < figuresList.size(); i++) {
            System.out.println("Flaeche Figur " + (i + 1) + ": " + figuresList.get(i).getArea());
        }
        getSumArea();
    }
        static void getSumArea() {
            double sumArea = 0;
            for (Figure figure : figuresList) {
                sumArea += figure.getArea();
            }
            System.out.println("Summe der Flaechen: " + sumArea);
        }
}

interface Figure {
    double getArea();

    void scale(double factor);
}

class Rectangle implements Figure {
    private double a;
    private double b;

    public Rectangle(double length, double width) {
        a = length;
        b = width;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public void scale(double factor) {
        a *= factor;
        b *= factor;
    }
}

class Circle implements Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public void scale(double factor) {
        this.radius *= factor;
    }
}


