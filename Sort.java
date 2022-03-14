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
    // quick sort --> divide and conquer
    // key idea:
    // divide an unsorted array by v, such that
    // 小小小小小v大大大大大
    // then sort 小 and 大 seperatedly
    // sort elements between start and end

    // Overload(only Java and C++...)
    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length-1);
    }
    public static void quickSort(int[] data, int start, int end) {
        // choose which v? simplest way is to choose datae[start]
        // then left <-- start+1, right <-- end
        // from left choose an element >= v
        // from right choose and element <= v 
        // swap left and right if left pos < right pos
        if (start >= end)
            return;
        int v = data[start];    // choose leftest element
        int left = start+1;
        int right = end;
        while (true) {
            while (left <= end && data[left] <= v)
                left++;
            while (data[right] > v)
                right--;
            if (left < right) {
                int tmp = data[left];
                data[left] = data[right];
                data[right] = tmp;
                left++;
                right--;
            } else
                break;
        }
        data[start] = data[right];
        data[right] = v;
        quickSort(data, start, right-1);
        quickSort(data, right+1, end);
    }
    public static void main(String[] argv) {
        // int[] data = new int[]{5, 2, 7, 1, 8, 4, 9};
        int[] data = new int[]{1,1,1,1,1,2,1,1,1};
        quickSort(data);
        for (int i = 0; i < data.length; i++)
            System.out.println(data[i]);
    }
}