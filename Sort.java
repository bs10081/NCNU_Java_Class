    // how to sort an array?
    // there are many algorithms
    // eg. insertion sort
    // if the firest n elements are sorted, then how to insert n+1 element
    // so that the first n+1 elemtns are sorted?
    
    // 1 2 3 4 5 6 7 4

    // 1 2 3 4 5 6 7 _
    //               4
    
    // 1 2 3 4 5 6 _ 7
    //               4

    // 1 2 3 4 5 _ 6 7
    //               4

    // 1 2 3 4 _ 5 6 7
    //               4
    
    // 1 2 3 4 4 5 6 7

public class Sort {
    public static void sort(int[] data) {
        for (int sorted = 1; sorted < data.length; sorted++) {
            int v = data[sorted];
            int pos = sorted-1;     // the position to compare
            while (pos >= 0 && data[pos] > v) {
                data[pos+1] = data[pos];    // move to next position
                pos -= 1;
            }
            data[pos+1] = v;
        }
        
    }
    // bubble sort
    public static void bubble(int[] data) {
        for (int unsorted = data.length; unsorted > 1; unsorted--) {
            // compare and swap
            for (int pos = 0; pos < unsorted-1; pos++)
                if (data[pos] > data[pos+1]) {
                    int tmp = data[pos];
                    data[pos] = data[pos+1];
                    data[pos+1] = tmp;
                }
        }
    }
    public static void main(String[] argv) {
        int[] data = new int[]{5, 2, 7, 1, 8, 4, 9};
        sort(data);
        for (int i = 0; i < data.length; i++)
            System.out.println(data[i]);
    }
}
