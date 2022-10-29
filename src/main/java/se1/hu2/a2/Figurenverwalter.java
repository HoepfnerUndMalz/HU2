package se1.hu2.a2;
import java.util.ArrayList;

public class Figurenverwalter {
    public static void main(String[] args) {
        ArrayList<Figure> figurenList = new ArrayList<Figure>();

        Figure Kreis = new Figure("Kreis", "circle", 3, 0, 1);
        Figure Quadrat = new Figure("Quadrat", "square", 4, 0, 1);
        Figure Rechteck1 = new Figure("Rechteck1", "rectangle", 2, 5, 1);
        Figure Rechteck2 = new Figure("Rechteck2", "rectangle", 2, 5, 2);

        figurenList.add(Kreis);
        figurenList.add(Quadrat);
        figurenList.add(Rechteck1);
        figurenList.add(Rechteck2);

        for (int i = 0; i < figurenList.size(); i++) {
//            System.out.println("Fläche Figur " + figurenList.get(i).name + ": " + figurenList.get(i).getFlaeche());
            System.out.println("Fläche Figur " + (i+1) + " " + figurenList.get(i).name + ": " + figurenList.get(i).getFlaeche());
 //           System.out.println("Fläche Figur ",figurenList.get(i).type , ": " + figurenList.get(i).getFlaeche());
        }

        getSumFlaeche(figurenList);
    }

    static void getSumFlaeche(ArrayList<Figure> figurenList) {
        double sumFlaeche = 0;
        for (Figure figure : figurenList) {
            sumFlaeche += figure.getFlaeche();
        }
        System.out.println("Summe der Flächen: " + sumFlaeche);
    }
}

class Figure {
    String name;
    String type;
    int attribute1;
    int attribute2;
    int scale;

    public Figure(String name, String type, int attribute1, int attribute2, int skale) {
        this.name = name;
        this.type = type;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.scale = skale;
    }

    double getFlaeche() {
        if (scale == 0) {
            scale = 1;
        }
        int attribute1local = attribute1 * scale;
        int attribute2local = attribute2 * scale;

        if (this.type == "circle") {
            return Math.PI * Math.pow(attribute1local, 2);
        } else if (this.type == "square") {
            return Math.pow(attribute1local, 2);
        } else if (this.type == "rectangle") {
            return attribute1local * attribute2local;
        } else {
            return 0;
        }
    }
}