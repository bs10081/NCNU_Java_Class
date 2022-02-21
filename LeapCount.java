// how many lep years between x and y?
// input: two integer
// output: leap year count
import java.util.Scanner;
public class LeapCount {
    public static boolean isLeap(int y) {
        return y%400 == 0 || y%100 != 0 && y%4 == 0;
    }
    public static int leapCount(int start, int end) {
        if (start > end) {
            int tmp;
            tmp = start;
            start = end;
            end = tmp;
        }
        int y = start;
        int count = 0;
        while (y <= end) {
            if (isLeap(y)) {
                count = count + 1;
            }
            y = y + 1;
        }
        return count;
    }
    public static void main(String[] argv ) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        System.out.println(leapCount(x, y));
    }
}