import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите x: ");
        double x = sc.nextDouble();
        System.out.print("Введите a: ");
        double a = sc.nextDouble();

        double up=1;
        double down=1;

        for (int i=1; i<64;i+=2){
            up*=(x-i-1);
            down*=(x-i);
        }

        System.out.println("y1 = "+up/down);

        double y=1;

        for (int j = 0;j<6;j++){
            y=y*x-a;
        }

        System.out.println("y2 = "+y);
    }
}