// 著色數獨
// input: 81 ints between 0-8 表示每個位置的區塊
// then 81 ints 表示每個位置已知的數字，若為0則表示空白
// 0 0 0 1 1 1 2 2 2 
// 0 0 0 1 1 1 2 2 2
// 0 0 0 1 1 1 2 2 2
// 3 3 3 4 4 4 5 5 5
// 3 3 3 4 4 4 5 5 5
// 3 3 3 4 4 4 5 5 5
// 6 6 6 7 7 7 8 8 8
// 6 6 6 7 7 7 8 8 8
// 6 6 6 7 7 7 8 8 8
import java.util.Scanner;

public class Unique {
    public static void main(String[] argv) {
        // input 81 ints between 0-8 表示每個位置的區塊
        Scanner input = new Scanner(System.in); 
        findSol(input.next(), input.next());
        input.close();
    }

    public static void findSol(String map, String data) {
        int[] m = new int[81];
        int[] d = new int[81];
        for (int i = 0; i < 81; i++) {
            m[i] = map.charAt(i) - '0';
            d[i] = data.charAt(i) - '0';
        }
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], block = new boolean[9][9];
        for (int pos = 0; pos < 81; pos++) {
            if (d[pos] != 0) { // 題目已經填入數字了
                // 判斷是否有重複
                row[pos / 9][d[pos]-1] = col[pos % 9][d[pos] - 1] = block[m[pos]][d[pos] - 1] = true;
            }
        }
        findSol(m, d, 0, row, col, block);
    }
        // map: 每個位置的區塊
        // data: 每個位置已知的數字，若為0則表示空白，範圍1～9
            // 同一直線、同一橫線、同一色塊 (區塊) 內的數字均須包含 1～9，不能缺少，也不能重複
        // pos: 負責的位置
        // row: boolean[9][9], row[r][d] 表示第 r 行第 d 個位置是否已知
        // col: boolean[9][9], col[c][d] 表示第 c 列第 d 個位置是否已知
        // block: boolean[9][9], col[b][d] 表示第 b 個區塊第 d 個位置是否用過，true表示用過，false表示未用過
    public static void findSol(int[] map, int[] data, int pos, boolean[][] row, boolean[][] col, boolean[][] block) {
        if (pos == 81) {
            // print data
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(data[i * 9 + j]);
                }
                System.out.println();
            }
            return;
        }

        if (data[pos] == 0) { //此位置空白
            for (int d = 1; d <= 9; d++) { // 試著填入1-9
                // if 可以填入數字 d
                if (!row[pos / 9][d-1] && !col[pos % 9][d-1] && !block[map[pos]][d-1]) {
                    // 填入數字 d
                    data[pos] = d;
                    row[pos / 9][d-1] = col[pos % 9][d-1] = block[map[pos]][d-1] = true;
                    findSol(map, data, pos + 1, row, col, block);
                    // 回溯
                    data[pos] = 0;
                    row[pos / 9][d-1] = col[pos % 9][d-1] = block[map[pos]][d-1] = false;
                }
            }
        } else {
            findSol(map, data, pos+1, row, col, block);
        }
    }
}
