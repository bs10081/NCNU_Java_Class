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
    }
}

public class Fold {
    public static double fold() {
        
    }
    public static void main(String[] argv) {

        // - - - input
        Scanner input = new Scanner(System.in);

        // r: How many line of data.
        // c: How many col of one line.
        // d: How many times need to run.
        // contorl: fold options.
        int rows, cols, contorl;

        rows = input.nextInt();
        cols = input.nextInt();

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
