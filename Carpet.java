// 謝爾賓斯基地毯
public class Carpet {
    public static Pen pen = new Pen();
    // 在座標 x,y (地毯的左下角) 上畫一個size大小的地毯
    public static void carpet(int size, int x, int y) {
        if (size == 1) {
            try {
                pen.flyTo(x, y);
                pen.runTo(x, y);
                Thread.currentThread().sleep(1); //sleep 1ms
            } catch (Exception error) {
            }
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
    // Sierpinski triangle
    public static void sierpinskiTriangle(int size, int x, int y) {
        if (size == 1) {
            try {
                pen.flyTo(x, y);
                pen.runTo(x, y);
                Thread.currentThread().sleep(1); //sleep 1ms
            } catch (Exception error) {
            } finally {
            }
            return;
        }
        // Math.sin(d*3.14/180) = Math.sin(d)
        sierpinskiTriangle(size/2, x, y); 
        sierpinskiTriangle(size/2, x+size/2, y);
        sierpinskiTriangle(size/2, x+size/4, (int)(y-size*Math.sin(60*3.14/180)/2));
    }
    public static void main(String[] args) {
        sierpinskiTriangle(243, 100, 300);
    }
}
