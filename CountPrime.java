import java.util.Scanner;
public class CountPrime {
    public static boolean isPrime(int begin) {
        int div = 2;
        // 排除 1 會被判斷為質數的 Bug
        if (begin == 1) {
            return false;
        }
        // 從 2 判斷到輸入的參數
        while (div < begin) {
            if (begin % div == 0) {
                return false;
            } 
            div = div + 1;
        }
        return true;
    }
    public static int findPrime(int begin, int end) {
        // 歸零次數
        int seed = 0;
        // 從 begin 判斷到 end
        while (begin <= end) {
            if (isPrime(begin)) {
                // 如果判斷結果為true，便記錄 +1
                seed = seed + 1;
            }
            begin = begin + 1;
        }
        return seed;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int begin = input.nextInt();
        int end = input.nextInt();
        System.out.println(findPrime(begin, end));
    }
}
