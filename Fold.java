<<<<<<< HEAD
// 題目連結：https://tfbs.site/fold-java
import java.util.Scanner;
import java.util.*;

public class ListArray{
    ListArray{

    }

    // list[start;end]
    public static int[] slice(int[] orig, int start, int end) {
        int[] result = new int[end-start];
        for (int i = 0, at = start; at < end; i+=1, at+=1)
            result[i] = orig[at];
        return result;
    }
    // list() + list()
    public static int[] add(int[] x,int[] y){
        int[] result = new int[x.length+y.length];
        int at = 0;
        for (int i = 0; i < x.length; i+=1, at+=1)
            result[at] = x[i];
        for (int i = 0; i < y.length; i+=1, at+=1)
            result[at] = y[i];
        return result;
    }
    // list() + i
    public static int[] append(int[] orig, int v){
        int[] result = new int[orig.length+1];
        for (int i = 0; i < orig.length; i+=1)
            result[i] = orig[i];
        result[orig.length] = v;
        return result;
    }
    public static int[] reverse(int[] orig){
        int[] result = new int[orig.length];
        for (int i = 0, at = orig.length-1; i < orig.length; i+=1, at-=1)
            result[at] = orig[i];
        return result;
    }
    public static int[] skip(int[] orig, int at){
        int[] result = new int[orig.length-1];
        for (int i = 0, j = 0; i < orig.length; i++)
            if (i != at){
                //result[j++] = orig[i];
                result[j] = orig[i];
                j += 1;
            }
        return result;
=======
import java.util.*;

class Solution { // create a solution class for solution
    int[][] matrix; // create a matrix field to store matrix
    int[] command; // create a command sequence for storing command
    int rows, cols; // length of row and col for calculation

    Solution(int[][] matrix, int[] command) { // input your testing data
        this.matrix = matrix;
        this.command = command;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    void solve() {
        for (int i : this.command) { // do the matrix operation by using
            if (i == 1)
                this.operationH();
            if (i == 0)
                this.operationV();
        }
    }

    int getAddup(int r, int c) { // add up the value
        int result = this.matrix[r][c];
        // this.matrix[r][c] = -1;
        return result;
    }

    void operationH() {
        // println((int)(this.cols/2));
        for (int r = 0; r < this.rows; ++r) {
            for (int c = 0; c < (int) (this.cols / 2); ++c) {
                int cur = this.matrix[r][c], addup = getAddup(r, this.cols - c - 1);
                this.matrix[r][c] = cur + addup;
            }
        }

        this.resizeMatrix(this.rows, (int) (this.cols / 2) + this.cols % 2);
        // this.output();
    }

    void operationV() {
        for (int r = 0; r < (int) (this.rows / 2); ++r) {
            for (int c = 0; c < this.cols; ++c) {
                int cur = this.matrix[r][c], addup = getAddup(this.rows - 1 - r, c);
                this.matrix[r][c] = cur + addup;
            }
        }

        this.resizeMatrix((int) (this.rows / 2) + this.rows % 2, this.cols);
        // this.output();
    }

    void resizeMatrix(int rows, int cols) {
        int[][] newMatrix = new int[rows][cols];

        // System.out.println("resize: " + rows + ", " + cols);

        for (int r = 0; r < rows; ++r)
            for (int c = 0; c < cols; ++c)
                newMatrix[r][c] = this.matrix[r][c];

        this.cols = cols;
        this.rows = rows;

        this.matrix = newMatrix;
    }

    void output() {
        for (int[] r : this.matrix) {
            for (int c : r)
                System.out.print(c > 0 ? c + " " : "");
            System.out.println();
        }
>>>>>>> Test
    }
}

public class Fold {
<<<<<<< HEAD
    public static double fold() {
        
    }
=======
>>>>>>> Test
    public static void main(String[] argv) {

        // - - - input
        Scanner input = new Scanner(System.in);

<<<<<<< HEAD
        // r: How many line of data.
        // c: How many col of one line.
        // d: How many times need to run.
        // contorl: fold options.
        int rows, cols, contorl;
=======
        // rows: How many line of data.
        // cols: How many col of one line.
        // commands: fold options.
        int rows, cols;
        int[][] matrix;
        int[] commands;

        Solution s;
>>>>>>> Test

        rows = input.nextInt();
        cols = input.nextInt();

<<<<<<< HEAD
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(rows);
        ArrayList<Integer> commands = new ArrayList<>();
        
        for(int i = 0; i < rows; ++i) matrix.add(new ArrayList<Integer>(cols));

        for(ArrayList<Integer> rowItem: matrix)
            for(int i = 0; i < cols; i++)
                rowItem.add(input.nextInt());
        contorl = input.nextInt();
        input.close();

        // - - - output
        System.out.println();

    }
}
=======
        matrix = new int[rows][cols];
        
        for (int r = 0; r < rows; ++r)
            for (int c = 0; c < cols; ++c)
                matrix[r][c] = input.nextInt();

        input.nextLine();
        
        String[] commandStr = input.nextLine().split(" ");
        commands = new int[commandStr.length];
        
        for (int i = 0; i < commandStr.length; ++i){
            // System.out.println(commandStr[i]);
            commands[i] = Integer.valueOf(commandStr[i]);
        }

        input.close();

        s = new Solution(matrix, commands);
        s.solve();
        s.output();
    }
}
>>>>>>> Test
