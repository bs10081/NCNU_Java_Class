// 3n + 1 problem
// input: two longs start and end
// oputput: longest sequence length of all sequence between start and end
import java.util.Scanner;
public class N3 {
    public static long seqLen(long n) {
        int length = 1;
        
        // Basic👇🏻
        // while (n != 1) {
        //     if (n % 2 == 0) {
        //         n = n / 2;
        //     } else {
        //         n = 3 * n + 1;
        //     }
        
        // - - -
        
        // Advanced👇🏻
        while (n != 1L) {
            n = n % 2 == 0 ? n / 2 : 3 * n + 1;
            length = length + 1;
        }
        return length;
    }
    public static long maxN3(long start, long end) {
        if (start > end) {
            long tmp = start;
            start = end;
            end = tmp;
        }
        long maxLen = 0;
        for (long i = start; i <= end; i = i+1) {
            long len = seqLen(i);
            if (len > maxLen) 
                maxLen = len;
        }
        return maxLen;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        long start = input.nextLong(), end=input.nextLong();
        System.out.println(start+ " " + end + " " + maxN3(start, end));
        input.close(); // God close the door, and put the dog.
    }
}