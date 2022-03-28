/*
--- TOC ---

Calc : fold logic and calculate new row and column.
Fold : Main function

*/

class Calc {
    
    public static int[][] downFlodUp(int[][] data, int row, int col) {
        // specific different row width for odd and even row
        int tempListRow;
        if (row % 2 == 0) {
            tempListRow = row / 2;
        } else {
            tempListRow = (row / 2) + 1;
        }

        int[][] tempList = new int[tempListRow][col];

        // init data for checking conditional
        // floating reult only happen while all the number already are float
        double newRow = (double) row;
        double judgingRow = (newRow + 1)/2;

        for (double r=0; r < tempListRow; r++){
            for (int c=0; c < col; c++) {
                // counvert r to int for indexing
                int newR = (int) r;
                // magic math can do the job
                if (r+1 != judgingRow) {
                    tempList[newR][c] = data[newR][c] + data[row-newR-1][c];
                } else {
                    tempList[newR][c] = data[newR][c];
                }
            }
        }

        return tempList;
    }

    public static int[][] rightFlodLeft(int[][] data, int row, int col) {
        // specific different col width for odd and even col
        int temListCol;
        if (col % 2 == 0) {
            temListCol = col / 2;
        } else {
            temListCol = (col / 2) + 1;
        }

        int[][] tempList = new int[row][temListCol];

        // init data for checking conditional
        // floating reult only happen while all the number already are float
        double newCol = (double) col;
        double judgingCol = (newCol + 1)/2;

        for (int r=0; r < row; r++){
            for (double c=0; c < temListCol; c++) {
                // counvert c to int for indexing
                int newC = (int) c;
                // magic math can do the job
                if (c+1 != judgingCol) {
                    tempList[r][newC] = data[r][newC] + data[r][col-newC-1];
                } else {
                    tempList[r][newC] = data[r][newC];
                }
            }
        }

        return tempList;
    }
    // calculate the row length of data
    public static int newRow(int[][] data) {
        return data.length;
    }
    // calculate the column length of data
    public static int newCol(int[][] data) {
        return data[0].length;
    }
}

public class Sampling {

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        // input for data default row, column and total number of fold instruction.
        int[] sizeAndMethodTimes = new int[3];
        for (int i = 0; i < sizeAndMethodTimes.length; i++) {
            sizeAndMethodTimes[i] = input.nextInt();
        }
        int row = sizeAndMethodTimes[0]; // default row
        int col = sizeAndMethodTimes[1]; // default column
        int methodTimes = sizeAndMethodTimes[2]; // total number of fold instruction

        // input unfold original data
        int[][] data = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                data[i][j] = input.nextInt();
            }
        }

        // input flod method instruction
        int[] methodContainer = new int[methodTimes];
        for (int i = 0; i < methodTimes; i++) {
            methodContainer[i] = input.nextInt();
        }

        /*
        read the flod instruction then flod,
        update flod data and newest row or column width
        */
        for (int i = 0; i < methodContainer.length; i++) {
            if (methodContainer[i] == 0) {
                data = Calc.downFlodUp(data, row, col);
                row = Calc.newRow(data);
            } else if (methodContainer[i] == 1){
                data = Calc.rightFlodLeft(data, row, col);
                col = Calc.newCol(data);
            }
        }

        // printing the result
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                    System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
        // close scanner
        input.close();
    }
}
