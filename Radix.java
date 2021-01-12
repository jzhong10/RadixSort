public class Radix {
    public static void main(String[] args) {
      
    }
    
    public static int nth(int n, int col) {
      //0 10 , 1 10, 2 100
      return Math.abs(n/(int) Math.pow(10, col) % 10);
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
    
    public static void radixSortSimple(SortableLinkedList data) {
      SortableLinkedList[] bucket = new SortableLinkedList[10];
      for (int i = 0; i<bucket.length; i++) {
        bucket[i] = new SortableLinkedList();
      }
      
      int n = 0;
      for (int i = 0; i<data.size(); i++) {
        int temp = data.get(i);
        if (temp>n) {
          n = temp;
        }
      }
      // find the largest number and take its length
      n = length(n);
      
      int passes = 0;
      while (passes<n) {
        //if 0 passes so far, sort 0th col. If 1 pass, sort 1st col
        int place = passes;
        
        //get the num, find its dig, add it to the bucket, remove it
        while (data.size()>0) {
          int num = data.get(0);
          int dig = nth(num, place);
          bucket[dig].add(num);
          data.remove(0);
        }
        merge(data, bucket);
        passes++;
      }
    }
    
    /* Plan is to split the data into pos and neg ints
       Sort them separately and then combine them
       Tail of sorted neg goes to head of sorted pos
       Inefficient? yeah... That or I can add more bucket slots
       Scratch all that.
       Sort it normally and then loop through the data
       if negative, remove and add to end. Magic.
    */
    public static void radixSort(SortableLinkedList data) {
      radixSortSimple(data);
      for (int i = 0; i<data.size(); i++) {
        int num = data.get(i);
        if (num<0) {
          data.add(0, data.remove(i));
          //i--;
        }
      }
    }
}
