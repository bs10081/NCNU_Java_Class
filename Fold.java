import java.util.Scanner;
public class Fold {
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        //input row,col,pos
        //then row rows
        int row = input.nextInt(), col = input.nextInt(), ops = input.nextInt();
        int[][] data = new int[row][col];
        // input matrix data
        for (int r = 0; r < row;r++)
            for (int c =0; c < col;c++)
                data[r][c] = input.nextInt();
        //do folding
        for (int done = 0; done < ops; done++){
            if (input.nextInt()==0){ //up
                int[][]result = new int[(row+1)/2][col];
                    for (int r = 0; r < result.length;r++)
                        for (int c =0; c<col;c++)
                            if (r+1 == (row+1)/2.0) // middle
                                result[r][c] = data[r][c];
                            else
                                result[r][c] = data[r][c] + data[row-r-1][c];
                        row = (row+1)/2;
                        data = result;
            input.close();
            } else {//left
                int[][]result = new int[row][(col+1)/2];
                    for (int r = 0; r < result.length;r++)
                        for (int c =0; c< result[0].length;c++)
                            if (c+1 == (col+1)/2.0) // middle //java上符號的算法是看左右兩邊的單位
                                result[r][c] = data[r][c];
                            else
                                result[r][c] = data[r][c] + data[r][col-c-1];
                        col = (col+1)/2;
                        data = result;
            }
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                System.out.print(data[r][c] + " ");
            }
            System.out.println();
        }
    }
}
