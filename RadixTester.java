public class RadixTester {
    public static void main(String[] args) {
      int n = 0;
      int c = 0;
      if (args.length>0) {
        n = Integer.parseInt(args[0]);
      }
      if (args.length>1) {
        c = Integer.parseInt(args[1]);
        System.out.println(Radix.nth(n, c) + "\n");
      }
      /*
      System.out.println(Radix.nth(n, c));
      System.out.println(Radix.nth(n, c));
      System.out.println(Radix.length(n));
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
      Radix.merge(og, buc);
      System.out.println(og.toString());
      System.out.println("of course it starts randomly working");
      og = new MyLinkedList();
      buc = new MyLinkedList[10];
      og.add("it all starts here");
      for (int i = 0; i<buc.length; i++) {
        buc[i] = new MyLinkedList();
        buc[i].add(i+"");
        buc[i].add(i*10+"");
      }
      Radix.merge(og, buc);
      System.out.println(og.toString());
      */

      SortableLinkedList orig = new SortableLinkedList();
      SortableLinkedList[] bucket = new SortableLinkedList[10];
      orig.add(100);
      System.out.println(orig.toString());
      for (int i = 0; i<bucket.length; i++) {
        bucket[i] = new SortableLinkedList();
        if (i<6) {
          bucket[i].add(i);
          bucket[i].add(i);
        }
      }
      Radix.merge(orig, bucket);
      System.out.println(orig.toString());
      
      SortableLinkedList nums = new SortableLinkedList();
      for (int i = 0; i<10; i+=2) {
        nums.add(i);
      }
      nums.add(0, 5);
      nums.add(0, 15);
      nums.add(0, 32);
      nums.add(0, 132);
      nums.add(0, 123132);
      System.out.println("\n" + nums.toString());
      Radix.radixSortSimple(nums);
      System.out.println("\n" + nums.toString());
      nums.add(0, -231);
      nums.add(-231);
      nums.add(-2);
      nums.add(-2);
      nums.add(-56);
      System.out.println("\n" + nums.toString());
      Radix.radixSort(nums);
      System.out.println("\n" + nums.toString());
    }
  }