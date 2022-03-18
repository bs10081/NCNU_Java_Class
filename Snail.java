import java.util.Scanner;
public class Snail {
    public static int climb(int height, int daily_dis, int night_dis) {
        int currentHigh = 0;
        int days = 1;
        while (currentHigh <= height) {
            currentHigh += daily_dis;
            if (currentHigh < height) {
                currentHigh = currentHigh - night_dis;
                days = days + 1;
            }
        }
        return days;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
            int height = input.nextInt();
            int daily_dis = input.nextInt();
            int night_dis = input.nextInt();
            System.out.println(climb(height, daily_dis, night_dis));
            input.close();
    }

}