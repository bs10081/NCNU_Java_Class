

public class Matrix {
    private int [][] data;
    private int row,col;
    public Matrix(int r, int c){
        this.row = r;
        this.col =c;
        this.data = new int [r][c];
    }

    // define another constructor
    // Java allows functions have the same name as long as can be
    // identifies by their parameters
    // this concept is called 'overloading' in programming language

    public Matrix(int[][]d){
        this.row = d.length;
        this.col = d[0].length;
        this.data = new int[this.row][this.col];
        for (int i = 0; i < row; i++)
            for(int j=0 ; j <col ;j++)
                data[i][j] = d[i][j];
    }
    public void print(){
        for (int i = 0; i < row; i++){
            for (int j = 0; j <col; j++)
                System.out.print(data[i][j]+" ");
                System.out.println();
        }
    }
    // add this Matrix with y , to create a new Matrix
    //c[i][j] = a[i][j] + b[i][j]
    public Matrix add(Matrix y){
        Matrix result = new Matrix(this.row,this.col);
        for (int r = 0; r < row; r++)
            for(int c = 0; c < col; c++)
                result.data[r][c] = this.data[r][c] + y.data[r][c];
        return result;
    }
    // multiply this matrix with y, to create a new Matrix
    // c[i][j] = sum(a[i][l]*b[k][j]) for k in a's second dimension
    // 1 2 3 * 1 2    12(1 2 3 * 1 1 3) 14
    // 2 1 3   1 3 =  12 13
    //         3 2
    public Matrix mul(Matrix y) {
        Matrix result = new Matrix(this.row, y.col);
        for (int r = 0; r < this.row; r++) {
            for (int c = 0; c < y.col; c++) {
                for (int k = 0; k < this.col; k++)
                result.data[r][c] += this.data[r][k] * y.data[k][c];
            }
        }
        return result;
    }
    public static void main(String[] argv) {
        int[][] data1 = new int[][]{{1,2,3}, {2,1,3}};
        int[][] data2 = new int[][]{{1,2}, {1,3}, {3,2}};
        Matrix m1 = new Matrix(data1);
        Matrix m2 = new Matrix(data2);
        m1.mul(m2).print();
        
    }
}
