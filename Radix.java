public class Radix {
    public static void main(String[] args) {
      int n = 0;
      int c = 0;
      if (args.length>0) {
        n = Integer.parseInt(args[0]);
      }
      if (args.length>1) {
        c = Integer.parseInt(args[1]);
      }
      System.out.println(nth(n, c));
      System.out.println(nth(n, c));
      System.out.println(length(n));
    }
    
    public static int nth(int n, int col) {
      //0 10 , 1 10, 2 100
      return n/(int) Math.pow(10, col) % 10;
    }
    
    public static int length(int n) {
      return (int) Math.log10(n)+1;
    }
}
