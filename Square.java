import java.util.Scanner;

public class Square {
    public static int[][] findSol(int n) {
        int[][] result = new int[n][n];
        int row = 0, col = n / 2;
        // 第一個數字填在第一列的中間
        result[row][col] = 1;
        // 依序填入 2 ~ n^2 個數字
        for (int i = 2; i < n * n + 1; i++) {
            // 計算右上方的座標
            int nextrow = (row - 1 + n) % n, nextcol = (col + 1) % n;
            // 下一個數字先填在右上，
            if (result[nextrow][nextcol] != 0) {
                // 已填寫則填在右上方的正下方
                nextrow = (row + 1) % n;
                nextcol = col;
            }
            // System.out.println(result[nextrow][nextcol]);
            result[nextrow][nextcol] = i;
            row = nextrow;
            col = nextcol;
            // 如果出界，則移動到另外一邊
        }
        return result;
    }

    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // 輸入 n ，限制為1-10之內的奇數
        int[][] data = findSol(input.nextInt());
        // 生成一個 n*n 的 array
        input.close();
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data.length; c++) {
                System.out.print(String.format("%02d ", data[r][c]));
            }
            System.out.println();
        }
    }
}
