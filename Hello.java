import java.util.Scanner;
public class Hello {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        System.out.println("Hello World, "+x);
        input.close();
    }
}