import java.util.Scanner;
public class Lucky {
    // 多少人點到的次數 < bound
    // @seat 每個位置被點到名的次數
    // @bound 被點到的次數少於 bound 算 **幸運**
    public static int count(int[] seat, int bound) {
        // 初始化人數
        int result = 0;
        for (int i = 0; i < seat.length; i+=1) {
            if (seat[i] < 3) {
                result++;
            }
        }
        return result;
    }
    // 點名：點名座位 pos 以及 pos 所在的 row and col 的所有人
    // @seat 每個位置被點到名的次數
    // @n 座位一定是 n*n 的大小
    // @pos 被點到的位置，左上角是 0，右下角是 n * n - 1，使用 row major.
    public static void cross(int[] seat, int n, int pos) {
        for (int i = 0; i < seat.length; i++) {
            // 將 row 及 col 的數值都 +1
            if (pos%n == i%n || pos/n == i/n)
                seat[i]++;
        }
    }
    // print < bound 的座號
    public static void printLucky(int[] seat, int bound) {
        for (int i = 0; i < seat.length; i++) {
            if (seat[i] < bound)
                System.out.print((i + 1)+ " ");   // 題目要求要有空白且輸出為橫的（println > print）
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] seat = new int [n*n]; // 一共有 n*n 個座位，一開始點到的次數都是 0
        while (count(seat, 3) >= 5) { // 當幸運人數 >= 5人
            cross(seat, n, input.nextInt() - 1); // 繼續點名
        }
        input.close();
        printLucky(seat, 3); // 印出幸運兒
    }
}
