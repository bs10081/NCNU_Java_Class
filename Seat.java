import java.util.Scanner;
public class Seat {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of students
        int gridNum = sc.nextInt();
        
        // Read the number of seats
        Student[] students = new Student[gridNum * gridNum];
        // Read the students' information
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(sc.nextInt());
        }
        // 呼叫建構子
        Seats seats = new Seats(students, gridNum);
    
        // 計算七天後學生需要隔離多久
        for (int dth = 0; dth < 7; dth++) {
            // 這次確診的學生
            int stdId;
            // 如果今天沒有同學確診，那麼就跳過
            if ((stdId = sc.nextInt()) == 0)
                continue;
            // 如果有確診，就判斷是否需要隔離
            seats.AStudentDiagnosed(stdId, dth);
        }
        // 輸出結果
        for (int i = 0; i < gridNum * gridNum; i++) {
            // 如果學生是教室邊長的最後一個，那麼就換行，否則就輸出空格
            if (i % gridNum == gridNum - 1)
                System.out.println(seats.grid[i].COVID19_touchDays); // 取出學生的隔離天數
            else
                System.out.print(seats.grid[i].COVID19_touchDays + " ");
        }
    }
}
// XPos: 接觸者的位置
// gridNum: 教室的大小
// grid: 教室的座位
// COVID19_touchDays: 學生的隔離天數
// stdId: 學生的編號
// nth: 第幾天
// dth: 第幾天後
class Seats {
    // All Students 的陣列（一維）
    Student grid[];
    // 教室的大小
    int gridNum;

    // 二維轉一維，資料結構從頭到尾都是一維，只能用一維跑
    int getPosFromVec(int x, int y) {
        // 判斷是否超出範圍
        if (x < 0 || x >= gridNum || y < 0 || y >= gridNum)
            return -1;
        // row * gridNum + col
        return gridNum * y + x;
    }

    // 將一維座標轉為二維座標，用於座標位置判斷
    // Position 2 Vector
    int[] getVecFromPos(int pos) {
        //                   #row                #col
        return new int[] { pos % gridNum, (int) (pos / gridNum) };
    }
    // 學生ID找出座標
    int getStudentPos(int num) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i].num == num)
                return i;
        }
        // 如果沒找到，就回傳-1
        return -1;
    }
    // 判斷周圍的學生
    void AStudentDiagnosed(int num, int dth) {
        // 八方位的座標
        int[][] yourXCoor = {
                { -1, -1 },
                { -1, 0 },
                { -1, 1 },
                { 0, -1 },
                { 0, 1 },
                { 1, -1 },
                { 1, 0 },
                { 1, 1 }
        };
        // 取出學生的座標(一維)
        int studentPos;
        // 通過學號找到確診學生位置（二維
        int[] studentCoor = getVecFromPos(studentPos = getStudentPos(num));
        // 紀錄確診者的隔離天數
        grid[studentPos].COVID19(dth);

        // 九宮格抓走
        for (int i = 0; i < yourXCoor.length; i++) {
            int[] imXVec = yourXCoor[i];
            int XPos = getPosFromVec(studentCoor[0] + imXVec[0], studentCoor[1] + imXVec[1]);
            
            // 如果沒有人，就跳過
            if (XPos == -1)
                continue;
            // 被接觸的學生，要被抓去關幾天
            grid[XPos].COVID19_touch(dth);
        }
    }
    // 建構子
    Seats(Student gird[], int gridNum) {
        this.grid = gird;
        this.gridNum = gridNum;
    }
}

// 學生的資料結構
class Student {

    int COVID19_touchDays = 0;
    // Student ID
    int num = -1;
    // 紀錄是否已經隔離，默認為否
    boolean flag = false;
    
    Student(int num) {
        this.num = num;
    }

    void COVID19_touch(int nth) {
        // 如果已經被隔離了，就跳過
        if (flag)
            return;

        int i;
        // 如果隔離天數是負的，就設為0，如果不是的話，就維持原樣
        COVID19_touchDays = (i = nth - 3) < 0 ? 0 : i;
    }
    // 確診 0~6 + 8，被隔離，從0天開始
    void COVID19(int nth) {
        COVID19_touchDays = nth + 8;
        flag = true;
    }
}
