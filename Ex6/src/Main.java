import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Product {
    int ID;
    String name;
    double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getFinalPrice() {
        return price;
    }
    public String getType() {
        return "Product";
    }
}

class Electronics extends Product {
    double WarrantyExpenses;
    public Electronics(String name, double price, double WarrantyExpenses) {
        super(name, price);
        this.WarrantyExpenses = WarrantyExpenses;
    }
    public double getFinalPrice() {
        return 1.1 * price + WarrantyExpenses;
    }
    public String getType() {
        return "Electronics";
    }
}

class Food extends Product {
    LocalDate ExpiryDate;
    public Food(double price, String name, LocalDate ExpiryDate) {
        super(name, price);
        this.ExpiryDate = ExpiryDate;
    }
    public double getFinalPrice() {
        if (ChronoUnit.DAYS.between(LocalDate.now(), ExpiryDate) < 7) {
            return 0.8 * price;
        }
        else {
            return price;
        }
    }
    public String getType() {
        return "Food";
    }
}

class Order {
    List<Product> products = new ArrayList <>();
    public void addProduct(Product p) {
        products.add(p);
    }

    public double getTotalPrice() {
        double sum = 0;
        for (Product p : products) {
            sum += p.getFinalPrice();
        }
        return sum;
    }

    public void inforDisplay() {
        for (Product p : products) {
            System.out.println(p.name + " - " + p.getType() + " - " + p.getFinalPrice());
        }
        System.out.println("Total: " + getTotalPrice());
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Order order = new Order();
        for (int i = 0; i < n; i ++) {
            String type = sc.next();

            if (type.equals("E")) {
            String name = sc.next();
            double price = sc.nextDouble();
            double WarrantyExpenses = sc.nextDouble();
            order.addProduct(new Electronics(name, price, WarrantyExpenses));
            }

            else if (type.equals("F")) {
                String name = sc.next();
                double price = sc.nextDouble();
                String dateStr = sc.next();

                LocalDate date = LocalDate.parse(dateStr);
                order.addProduct(new Food(price, name, date));
            }
        }

        order.inforDisplay();
    }
}
