
// 110213027
// 簡齊君
import java.util.Scanner;

public class Snail {
    public static int climb(int height, int daily_dis, int night_dis) {
        int currentHigh = 0;
        int days = 1;
        // 如果每天爬行的高度，加上之前爬行的高度，低於最高的高度，則繼續爬行
        while (currentHigh <= height) {
            currentHigh += daily_dis;
            // 如果爬行的高度加上每天爬行的高度，超過最高的高度，則爬行的高度等於最高的高度
            if (currentHigh < height) {
                currentHigh = currentHigh - night_dis;
                days = days + 1;
            }
        }
        return days;
    }

    // currentHigh: the current highest
    // height: the highest
    // daily_dis: the distance traveled today
    // night_dis: the distance traveled tonight
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // 讀取輸入的高度
        int height = input.nextInt();
        int daily_dis = input.nextInt();
        int night_dis = input.nextInt();
        // 利用climb，計算爬行的天數
        System.out.println(climb(height, daily_dis, night_dis));
        input.close();
    }
}