import java.util.Scanner;
class Room {
    int nights;
    int price;
    public Room(int nights, int price) {
        this.nights = nights;
        this.price = price;
    }

    public int getFinalPrice() {
        return price * nights;
    }
}
class Standard extends Room {
    public Standard(int nights) {
        super(nights, 500000);
    }
    public int getFinalPrice() {
        int total = super.getFinalPrice();
        if (nights > 3) {
            return (int) (total * 0.95);
        }
        else {
            return total;
        }
    }
}
class Vip extends Room {
    public Vip(int nights) {
        super(nights, 2000000);
    }
    public int getFinalPrice() {
        int total = super.getFinalPrice();
        return total;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String type = sc.next();
            int nights = sc.nextInt();

            Room room;

            if (type.equals("S")) {
                room = new Standard(nights);
            }
            else {
                room = new Vip(nights);
            }

            System.out.println(room.getFinalPrice());
        }
    }
}
