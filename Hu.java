import java.util.Scanner;

class Hu {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);

        int[] data = new int[40]; // 先建立一個長度為34的array
        for (int i = 0; i < data.length; i++)
            data[i] = 0; // 先把array全部設為0
        for (int i = 0; i < 34; i++) {
            data[i] = input.nextInt();
        }

        String[] card = { "一萬", "二萬", "三萬", "四萬", "五萬", "六萬", "七萬", "八萬", "九萬", "一筒", "二筒", "三筒", "四筒", "五筒", "六筒",
                "七筒", "八筒", "九筒", "一條", "二條", "三條", "四條", "五條", "六條", "七條", "八條", "九條", "東風", "南風", "西風", "北風", "紅中",
                "青發", "白板" };

        for (int i = 0; i < 34; i++) {
            if (data[i] <= 3) {
                data[i]++;
                if (findSol(data, true)) {
                    System.out.println(card[i]);
                }
                data[i]--;
            }
        }

        return;
    }

    public static boolean findSol(int[] data, boolean needMJ) {
        boolean result = false;

        for (int i = 0; i < 34; i++) {
            if (data[i] == 0) {
                continue;
            }

            if (data[i] > 2) {
                data[i] -= 3;
                if (findSol(data, needMJ)) {
                    result = true;
                }
                data[i] += 3;
            }

            if (data[i] > 0 && data[i] >= 2) {
                data[i] -= 2;
                if (findSol(data, false)) {
                    result = true;
                }
                data[i] += 2;
            }

            if (data[i] >= 1 && data[i + 1] >= 1 && data[i + 2] >= 1
                    && (i < 7 || (8 < i && i < 16) || (17 < i && i < 25))) {
                data[i] -= 1;
                data[i + 1] -= 1;
                data[i + 2] -= 1;
                if (findSol(data, needMJ)) {
                    result = true;
                }
                data[i] += 1;
                data[i + 1] += 1;
                data[i + 2] += 1;
            }
            return result;
        }

        return true;
    }
}