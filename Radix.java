public class Radix {
    public static void main(String[] args) {
      
    }
    
    public static int nth(int n, int col) {
      return n/(int) Math.pow(10, col) % 10;
    }
    
    public static int length(int n) {
      if (n==0) {
        return 1;
      }
      n = Math.abs(n);
      return (int) Math.log10(n)+1;
    }
    
    public static void merge(MyLinkedList original, MyLinkedList[] buckets) {
      for (int i = 0; i<buckets.length; i++) {
        original.extend(buckets[i]);
      }
    }
    
    public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
      for (int i = 0; i<buckets.length; i++) {
        original.extend(buckets[i]);
      }
    }
    
    public static void mergeReverse(SortableLinkedList original, SortableLinkedList[] buckets) {
      for (int i = buckets.length-1; i>=0; i--) {
        original.extend(buckets[i]);
      }
    }
    
    public static void radixSortSimple(SortableLinkedList data) {
      SortableLinkedList[] bucket = new SortableLinkedList[10];
      for (int i = 0; i<bucket.length; i++) {
        bucket[i] = new SortableLinkedList();
      }
      
      int n = 1;
      
      int passes = 0;
      while (passes<n) {
        //if 0 passes so far, sort 0th col. If 1 pass, sort 1st col
        int place = passes;
        
        //get the num, find its dig, add it to the bucket, remove it
        while (data.size()>0) {
          int num = data.remove(0);
          if (place==0 && length(num)>n) {
            n = length(num);
          }
          int dig = nth(num, place);
          bucket[dig].add(num);
        }
        
        merge(data, bucket);
        passes++;
      }
    }
    
    public static void radixSort(SortableLinkedList data) {
      //radixSortSimple(data);
      /* //Method 1: add all the negative values to the front
      for (int i = 0; i<data.size(); i++) {
        int num = data.remove(i);
        if (num<0) {
          data.add(0, num);
        } else {
          data.add(i, num);
        }
      }
      */
      // Method 2, use two buckets, one for negs and pos
      // combine neg then pos, if nth() is neg, add to neg, try method
      SortableLinkedList[] bucketP = new SortableLinkedList[10];
      SortableLinkedList[] bucketN = new SortableLinkedList[10];
      for (int i = 0; i<bucketP.length; i++) {
        bucketP[i] = new SortableLinkedList();
        bucketN[i] = new SortableLinkedList();
      }
      
      int n = 1;
      
      int passes = 0;
      while (passes<n) {
        //if 0 passes so far, sort 0th col. If 1 pass, sort 1st col
        int place = passes;
        
        //get the num, find its dig, add it to the bucket, remove it
        while (data.size()>0) {
          int num = data.remove(0);
          if (place==0 && length(num)>n) {
            n = length(num);
          }
          int dig = nth(num, place);
          if (num<0) {
            bucketN[-1 * dig].add(num);
          } else {
            bucketP[dig].add(num);
          }
        }
        
        mergeReverse(data, bucketN);
        merge(data, bucketP);
        passes++;
      }
    }
}
