import java.util.Scanner;
public class Hello {
    public static void main(String[] argv) {
        // byte, short, int, long, float, double, boolean, char
        // int x;
        // float y;
        // x = 6;
        // y = (float)6.1;
        // x = (int)y;
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        System.out.println("Hello World, "+x);
    }
}