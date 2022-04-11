// 謝爾賓斯基地毯
public class Carpet {
    public static Pen pen = new Pen();
    // 在座標 x,y (地毯的左下角) 上畫一個size大小的地毯
    public static void carpet(int size, int x, int y) {
        if (size == 1) {
            pen.flyTo(x, y);
            pen.runTo(x, y);
            return;
        }
        carpet(size/3, x, y); //左下
        carpet(size/3, x+size/3, y);
        carpet(size/3, x+2*size/3, y);
        carpet(size/3, x, y-size/3);
        carpet(size/3, x+2*size/3, y-size/3);
        carpet(size/3, x, y-2*size/3);
        carpet(size/3, x+size/3, y-2*size/3);
        carpet(size/3, x+2*size/3, y-2*size/3);
    }
    public static void main(String[] args) {
        carpet(243, 100, 500);
    }
}
