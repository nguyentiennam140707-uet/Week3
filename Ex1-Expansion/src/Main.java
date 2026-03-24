class Person {
    String name;
    String dob;
    public Person(String name) {
        this.name = name;
        System.out.println("1. Person is created");
    }
}

class Employee extends Person {
    double salary;
    public Employee(double salary, String name) {
        super(name);
        this.salary = salary;
        System.out.println("2. Employee is created");
    }
}

class Manager extends Employee {
    String department;
    public Manager(String department, double salary, String name) {
        super(salary, name);
        this.department = department;
        System.out.println("3. Manager is created");
    }
}

public class Main {
    public static void main(String[] args) {
        Manager m = new Manager("IT", 5000, "Nam");           
    }
}