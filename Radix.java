public class Radix {
    public static void main(String[] args) {
      int n = Integer.parseInt(args[0]);
      int c = Integer.parseInt(args[1]);
      System.out.println(nth(n, c));
    }
    
    public static int nth(int n, int col) {
      //0 10 , 1 10, 2 100
      return n/(int) Math.pow(10, col) % 10;
    }
}
