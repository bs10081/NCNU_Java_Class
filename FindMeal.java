// 學號：110213027
// 姓名：簡齊君
// Power by Github Copilot
import java.util.Scanner;
public class FindMeal {
    // 選擇餐點
    public static String chooseR(Restaurant[] allR, int budget, int n) {
        int caneat = 0, toolow = 0, toohigh = 0, who = 0; // 分別紀錄可以吃的餐廳、餐廳費用太低、餐廳費用太高、符合的餐廳
        for (int i = 0; i < n; i++) {
            if (allR[i].lp > budget) 
                // 如果餐廳費用太低，就不算在可以吃的餐廳中
                toolow++;
            else if (allR[i].hp > budget) { 
                // 如果餐廳費用符合，就算在可以吃的餐廳中
                caneat++;
                who = i;
            } else 
                // 如果餐廳費用太高，就不算
                toohigh++;
        }
        if (caneat == 1)
            // 如果只有一家餐廳可以吃，就直接回傳餐廳名稱
            return allR[who].name;
        else if (caneat > 1)
            return "有選擇困難";
            // 如果有多家餐廳可以吃，就回傳"有選擇困難"
        else if (toohigh > 0 && toolow == 0)
            return "預算出太多了";
            // 如果預算費用太高，但是餐廳費用太低，就回傳"預算出太多了"
        else if (toolow > 0 && toohigh == 0)
            return "預算出太少了";
            // 如果預算費用太低，但是餐廳費用太高，就回傳"預算出太少了"
        else
            return "買不了";
            
    }

    // main function
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        // 先建立餐廳陣列
        Restaurant[] allR = new Restaurant[n];
        for (int r = 0; r < n; r++)
            allR[r] = new Restaurant(input.next(), input.nextInt(), input.nextInt());
            // 將餐廳資訊輸入餐廳陣列
        int m = input.nextInt();
        for (int c = 0; c < m; c++)
            System.out.println(chooseR(allR, input.nextInt(), n));
            // 將預算費用輸入，並輸出結果
        // 關閉輸入
        input.close();
    }
}

// 餐廳的資訊
class Restaurant {
    public String name;
    public int lp;
    public int hp;

    public Restaurant(String name, int lp, int hp) {// 輸入的資料,放進類裡面
        this.name = name;
        this.lp = lp;
        this.hp = hp;
    }
}