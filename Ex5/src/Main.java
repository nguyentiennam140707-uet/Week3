import java.util.Scanner;
abstract class Employee {
    String name;
    int DayOfBirth;
    int MonthOfBirth;
    int YearOfBirth;
    int EmployeeId;

    public Employee(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public abstract String getType();
    
}

class FullTimeEmployee extends Employee {
    int baseSalary;
    int bonus;
    int penalty;
    public FullTimeEmployee(String name, int baseSalary, int bonus, int penalty){
        super(name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }
    public String getName(){
        return name;
    }
    public int getBaseSalary(){
        return baseSalary;
    }
    public int getBonus(){
        return bonus;
    }
    public int getPenalty(){
        return penalty;
    }
    public String getType() {
        return "Full-time";
    }
    public void inforDisplay(){
        System.out.println(getName() + " - " + getType()  + " - " + (baseSalary + (bonus - penalty)));
    }
}

class PartTimeEmployee extends Employee {
    int workingHours;
    int hourlyRate;
    public PartTimeEmployee(String name, int workingHours, int hourlyRate) {
        super(name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }
    public String getName(){
        return name;
    }
    public int getWorkingHours(){
        return workingHours;
    }
    public int getHourlyRate(){
        return hourlyRate;
    }
    public String getType() {
        return "Part-time";
    }
    public void inforDisplay(){
        System.out.println(getName() + " - " + getType() + " - " + (workingHours * hourlyRate));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Employee[] m = new Employee[n];
        for (int i = 0; i < n; i++) {
            String type = sc.nextLine();
            if (type.equals("F")) {
                String name = sc.nextLine();
                int baseSalary = sc.nextInt();
                int bonus = sc.nextInt();
                int penalty = sc.nextInt();
                sc.nextLine();
                m[i] = new FullTimeEmployee(name, baseSalary, bonus, penalty);
            }
            else if (type.equals("P")) {
                String name = sc.nextLine();
                int workingHours = sc.nextInt();
                int hourlyRate = sc.nextInt();
                sc.nextLine();
                m[i] = new PartTimeEmployee(name, workingHours, hourlyRate);
            }
        }

        for (int i = 0; i < n; i ++) {
            if (m[i] instanceof FullTimeEmployee) {
                ((FullTimeEmployee) m[i]).inforDisplay();
            }
            else if (m[i] instanceof PartTimeEmployee) {
                ((PartTimeEmployee) m[i]).inforDisplay();
            }
        }
    }
}

