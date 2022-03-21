public class Perm {
    // skip one elemen at position pos, reutrn remaing data
    public static char[] skip(char[] data, int pos) {
        char[] result = new char[data.length-1];
        for (int i = 0, j = 0; i < data.length; i++) {
            if (i != pos) {
                result[j++] = data[i];
            }
        }
        return result;
    }
    // append v to the end of data
    public static char[] append(char[] data, char v) {
        char[] result = new char[data.length+1];
        for (int i = 0; i < data.length; i++) 
            result[i] = data[i];
        result[data.length] = v;
        return result;
    }
    public static void perm(char[] avail, int n) {
        perm(avail, n, new char[0]);
    }
    // avail: 那些資料可選
    // n: 要選出幾個
    // result: 前面已經選好的
    public static void perm(char[] avail, int n, char[] result) {
        if (n == 0) {
            for (int i = 0; i < result.length; i++)
                System.out.print(result[i]);
            System.out.println();
            return;
        } // 核心程式
        for (int pos = 0; pos < avail.length; pos++) {
            perm(skip(avail, pos), n-1, append(result, avail[pos]));
        }
    }
    public static void main(String[] argv) {
        perm(new char[]{'a', 'b', 'c', 'd', 'e', 'f'}, 3);
    }
}