// reverse and add
// input: n then n ints
// output: n lines of seqLen and final result
import java.util.Scanner;
public class ReverseAndAdd {
    public static long reverse(long n) {
        long revsNum = 0;
        while (n != 0) {
            revsNum = revsNum * 10 + n % 10;
            n = n / 10;
        }
        return revsNum;
    }
    public static void findSol(long n) {
        int seqLen = 0;
        do {
            n = n + reverse(n);
            seqLen = seqLen + 1;
        } while (n != reverse(n));
        System.out.println(seqLen+ " " + n);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i = i+1) {
            findSol(input.nextInt());
        }
        input.close();
    }
}