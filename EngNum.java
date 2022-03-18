public class EngNum {
    public static void main(String[] argv) {
        for(int T = 0; T < 9; T++)
        for(int G = 0; G < 9; G++)
        for(int O = 0; O < 9; O++)
        for(int D = 0; D < 9; D++)
        if(4*(T*100+O*10+O) == G*1000 + O*100 + O*10 + D) 
        System.out.println("T: " + T + ", G: " + G + ", O: "+ O + ", D: " + D);
    }
}
