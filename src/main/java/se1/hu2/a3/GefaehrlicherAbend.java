package se1.hu2.a3;

import java.util.ArrayList;
import java.util.List;


public class GefaehrlicherAbend {
    public static void main(String[] args) {
        Villa riesenVilla = new Villa();
        System.out.println("Villa unbewacht");

        riesenVilla.zombieGreiftAn();

        new Wachhund(riesenVilla);

        riesenVilla.zombieGreiftAn();

        new Alarmanlage(riesenVilla);
        new Wachmann(riesenVilla);

        riesenVilla.zombieGreiftAn();
    }
}
class Villa {

    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void zombieGreiftAn(){
        System.out.println("(Einbruchsversuch)");
        for (Observer observer : observers) {
            observer.update();
        }
        if (observers.size() > 0){
        System.out.println("Einbrecher laeuft weg. Glueck gehabt!");
        } else {
            System.out.println("Einbrecher raeumt Tresor aus ... und ist ueber alle Berge.");
        }
        System.out.println();
    }
}

 abstract class Observer {
    protected Villa subject;
    public abstract void update();
}

class Wachhund extends Observer{

    public Wachhund(Villa subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("GRRR, RRRR ----- BEISS");
    }
}

class Alarmanlage extends Observer{

    public Alarmanlage(Villa subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("ALARM! ALARM!");
    }
}

class Wachmann extends Observer{

    public Wachmann(Villa subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Halt oder ich schiesse!");
    }
}



