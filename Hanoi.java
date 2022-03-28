public class Hanoi {
    // move n disks from a to b
    public static void move(int n, char a, char b, char c) {
        // if no disk to move, than return
        if (n == 0) return;
        // move n-1 disks from a to c
        move(n-1, a, c, b);
        // move the last disk from a to b
        System.out.println("move disk " + n + " from " + a + " to " + b);
        // move n-1 disks from c to b
        move(n-1, c, b, a);
    }
    // main function
    public static void main(String[] argv) {
        move(3, 'a', 'b', 'c');
    }
}