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
      MyLinkedList og = new MyLinkedList();
      for (int i = 0; i<5; i++) {
        og.add(i+"");
      }
      System.out.println();
      System.out.println(og.toString());
      MyLinkedList[] buc = new MyLinkedList[10];
      for (int i = 0; i<buc.length; i++) {
        buc[i] = new MyLinkedList();
      }
      buc[0].add("9");
      buc[0].add("1");
      buc[1].add("8");
      System.out.println(buc[0].toString());
      System.out.println(buc[1].toString());
      
      og.extend(buc[1]);
      System.out.println(og.toString());
      System.out.println(buc[1].toString());
      System.out.println();
      og.extend(buc[2]);
      System.out.println(og.toString());
      System.out.println(buc[2].toString());
      //merge(og, buc);
      
      System.out.println(og.toString());
      System.out.println(buc[0].toString());
      System.out.println(buc[1].toString());
      
      System.out.println();
      merge(og, buc);
      System.out.println(og.toString());
      System.out.println("of course it starts randomly working");
      og = new MyLinkedList();
      buc = new MyLinkedList[10];
      for (int i = 0; i<buc.length; i++) {
        buc[i] = new MyLinkedList();
        buc[i].add(i+"");
        buc[i].add(i*10+"");
      }
      merge(og, buc);
      System.out.println(og.toString());
    }
    
    public static int nth(int n, int col) {
      //0 10 , 1 10, 2 100
      return n/(int) Math.pow(10, col) % 10;
    }
    
    public static int length(int n) {
      if (n==0) {
        return 1;
      }
      return (int) Math.log10(n)+1;
    }
    
    public static void merge(MyLinkedList original, MyLinkedList[] buckets) {
      for (int i = 0; i<buckets.length; i++) {
        // /System.out.println(buckets[i].toString());
        original.extend(buckets[i]);
      }
    }
}
