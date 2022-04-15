
// 科赫曲線
public class KochSnow extends Thread{
    public static Pen pen = new Pen();
    // 定義起點
    // 由起點(x, y)長度1,角度t
    private int x, y, length, t;
    public KochSnow(int x, int y, int length, int t) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.t = t;
    }
    public void run() {
        koch(x,y,length,t);
    }
    //定義科赫曲線
    public static void koch(int x, int y, int length, int t) {
        if (length == 1) {
            pen.flyTo(x, y);
            pen.runTo(x, y);
            try {
                Thread.currentThread().sleep(1); //sleep 1ms
            } catch (Exception error) {
            }
            return;
        }
        // DOWN
        // koch(x, y, length / 3, t);
        // koch((int)(x + Math.cos(3.14/180*t) * length / 3), (int)(y + Math.sin(3.14/180*t)* length / 3), length / 3, t + 60);
        // koch((int)(x + Math.cos(3.14/180*t) * length / 3 + Math.cos(3.14/180*(t+60)) * length / 3), (int)(y + Math.sin(3.14/180*t)* length / 3 + Math.sin(3.14/180*(t+60)) * length / 3), length / 3, t - 60);
        // koch((int)(x + Math.cos(3.14/180*t) * length * 2 / 3), (int)(y + Math.sin(3.14/180*t)* length * 2 / 3), length / 3, t);
        
        // 反轉(UP)
        koch(x, y, length / 3, t);
        koch((int)(x + Math.cos(3.14/180*t) * length / 3), (int)(y - Math.sin(3.14/180*t)* length / 3), length / 3, t + 60);
        koch((int)(x + Math.cos(3.14/180*t) * length / 3 + Math.cos(3.14/180*(t+60)) * length / 3), (int)(y - Math.sin(3.14/180*t)* length / 3 - Math.sin(3.14/180*(t+60)) * length / 3), length / 3, t - 60);
        koch((int)(x + 2 * Math.cos(3.14/180*t) * length / 3), (int)(y - 2 * Math.sin(3.14/180*t)* length / 3), length / 3, t);
    }
    public static void main(String[] argv) {
        KochSnow l1 = new KochSnow(100, 300, 81*3, 0); // up
        KochSnow l2 = new KochSnow(100+81*3, 300, 81*3, -120); // right
        KochSnow l3 = new KochSnow(100+81*3/2, (int)(300-81*3*Math.sin(3.14/180*-60)), 81*3, 120); // down
        l1.start();
        l2.start();
        l3.start();
    }
}