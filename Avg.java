// input: n then n doubles
// output: average and standard deviation
import java.util.Scanner;
public class Avg{
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[] data = new double[n]; // reference to array of double
        for (int i = 0; i < n; i+=1)
            data[i] = input.nextDouble();
        double sum = 0;
        for (int i = 0; i < n; i+=1)
            sum += data[i];
        double avg = sum / n;
        sum = 0;
        for (int i = 0; i < n; i+=1)
            sum += (data[i] - avg) * (data[i] - avg);
        double dev = Math.sqrt(sum / n);
        System.out.println(avg+" "+dev);
        input.close();
    }
}