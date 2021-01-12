public class Radix {
    public static void main(String[] args) {
      
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
    
    public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
      for (int i = 0; i<buckets.length; i++) {
        // /System.out.println(buckets[i].toString());
        original.extend(buckets[i]);
      }
    }
}
