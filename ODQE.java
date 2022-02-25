import java.util.Scanner;

// ax^2 + bx + c = 0
// (-b +- sqrt(b * b - 4ac)) / 2a

public class ODQE {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        double a, b, c;
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        input.close();
        if (a == 0 && b == 0 && c == 0) {
            // a = b = c = 0, infinite solutions
            System.out.println("Infinite solutions.");
            
        } else if (a == 0 && b == 0 && c != 0) {
            // a = b = 0, c != 0, no solution
            System.out.println("No solution.");
        } else if (a == 0) {
            // a = 0, -c/b
            System.out.println(-c/b);
        } else if (b*b - 4*a*c < 0) {
            // b * b - 4ac < 0, no solution
            System.out.println("No solution.");
        } else if (b*b - 4*a*c == 0) {
            // b * b - 4ac == 0, one solution
            System.out.println("One slution.");
        } else if (b*b - 4*a*c > 0) {
            // b * b - 4ac > 0, two solution
            System.out.println("Two solution.");
        } else {
            System.out.println((-b + Math.sqrt(b * b - 4*a*c))/(2*a));
            System.out.println((-b - Math.sqrt(b * b - 4*a*c))/(2*a));    
        }
    }
}
