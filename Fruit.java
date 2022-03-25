import java.util.Scanner;
public class Fruit {
    // return true if foundd solution, otherwise return false
    public static int findSol(int money, int n, int[] prices, int species) {
        return findSol(money, n, prices, species, 0, new int[species]);
    }

    // money: money we have
    // n: how many fruits we want to buy
    // species: how many species of fruits we have
    // prices: prices of each species
    // kind: which kind of fruit we buy
    // result: 水果籃內每一種水果買好的數量
    // return true if found at least one solution, otherwise return false
    public static int findSol(int money, int n, int[] prices, int species, int kind, int[] result) {
        // if we have bought all the fruits we want, return true
        if (n == 0) {
            return 1;
        }
        // if we have no more species of fruits, return false
        if (kind == species) {
            return 0;
        }
        int found = 0;
        // if we can buy the first kind of fruit, try to buy it
        for (int c = 0; c <= (money / prices[kind] <= n ? money / prices[kind] : n); c++) {
            result[kind] = c; // 記錄買了幾個
            // buy this kind c fruits
            found += findSol(money - c * prices[kind], n - c, prices, species, kind + 1, result);
            result[kind] = 0; // 清除記錄
        }
        return found;
    }

    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // input money, n, species, prices
        int money = input.nextInt();
        int n = input.nextInt();
        int species = input.nextInt();
        int[] prices = new int[species];
        for (int i = 0; i < species; i++) {
            prices[i] = input.nextInt();
        }
        input.close();
        System.out.println(findSol(money, n, prices, species));
    }
}
