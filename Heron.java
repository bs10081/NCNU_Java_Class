import java.util.Scanner; // import Basic input library

public class Heron {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        double a, b, c;
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        double s = (a+b+c)/2;
        Math.sqrt(2);
        System.out.println(Math.sqrt(s*(s-a)*(s-b)*(s-c)));
    }
}
