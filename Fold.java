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
    }
}

public class Fold {
    public static void main(String[] argv) {

        // - - - input
        Scanner input = new Scanner(System.in);

        // rows: How many line of data.
        // cols: How many col of one line.
        // commands: fold options.
        int rows, cols;
        int[][] matrix;
        int[] commands;

        Solution s;

        rows = input.nextInt();
        cols = input.nextInt();

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