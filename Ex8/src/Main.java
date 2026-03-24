import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

abstract class Robot {
    private int id;
    private String modelName;
    private int batteryLevel;

    public Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
        this.batteryLevel = 0;
    }

    public void chargeBattery() {
        batteryLevel = 100;
    }

    public final void showIdentity() {
        System.out.println("ID: " + id + ", Model: " + modelName);
    }

    public String getModelName() {
        return modelName;
    }

    public abstract void performMainTask();
}

interface Flyable {
    void fly();
}   
interface Swimmable {
    void swim();
}
interface GPS {
    void getCoordinates();
}

class DroneRobot extends Robot implements Flyable, GPS {

    public DroneRobot(int id, String modelName) {
        super(id, modelName);
    }

    public void performMainTask() {
        System.out.println(getModelName() + " performing main task");
    }

    public void fly() {
        System.out.println(getModelName() + " flying");
    }

    public void getCoordinates() {
        System.out.println(getModelName() + " getting coordinates");
    }
}

class FishRobot extends Robot implements Swimmable {

    public FishRobot(int id, String modelName) {
        super(id, modelName);
    }

    public void performMainTask() {
        System.out.println(getModelName() + " performing main task");
    }

    public void swim() {
        System.out.println(getModelName() + " swimming");
    }
}

class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS {

    public AmphibiousRobot(int id, String modelName) {
        super(id, modelName);
    }

    public void performMainTask() {
        System.out.println(getModelName() + " performing main task");
    }

    public void fly() {
        System.out.println(getModelName() + " flying");
    }

    public void swim() {
        System.out.println(getModelName() + " swimming");
    }

    public void getCoordinates() {
        System.out.println(getModelName() + " getting coordinates");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Robot> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int id = sc.nextInt();
            String name = sc.next();

            if (type.equals("DR")) {
                list.add(new DroneRobot(id, name));
            }
            else if (type.equals("FR")) {
                list.add(new FishRobot(id, name));
            }
            else if (type.equals("AR")) {
                list.add(new AmphibiousRobot(id, name));
            }
        }

        for (Robot r : list) {
            r.performMainTask();

            if (r instanceof Flyable) {
                ((Flyable) r).fly();
            }
            if (r instanceof Swimmable) {
                ((Swimmable) r).swim();
            }
            if (r instanceof GPS) {
                ((GPS) r).getCoordinates();
            }
            System.out.println();
        }
    }
}