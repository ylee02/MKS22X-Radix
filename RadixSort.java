import java.util.*;
public class RadixSort {
  public static void radixsort(int[]data){
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < 20; i++) {
      buckets[i] = new MyLinkedList<Integer>();
    }
    MyLinkedList<Integer> temp = new MyLinkedList<Integer>();

    int max = Math.abs(data[0]);
    for (int i = 1; i < data.length; i++) {
      if (Math.abs(data[i]) > max) {
        max = Math.abs(data[i]);
      }
    }
    int length = String.valueOf(max).length();
    for (int i : data) {
      if (i < 0) {
        buckets[9 - (Math.abs(i) % 10)].add(i);
      } else {
        buckets[10 + (Math.abs(i) % 10)].add(i);
      }
    }
    int curr = 1;
    for (MyLinkedList<Integer> bucket : buckets) {
        temp.conjoin(bucket);
        bucket.clear();

    }

    while (curr <= length) {
      for (int i = 0; i < temp.size(); i++) {
        int num = temp.get(i);
        int digit = (Math.abs(num) % (int)Math.pow(10, curr)) / (int)Math.pow(10, curr - 1);
        if (num < 0) {
          buckets[9 - digit].add(num);
        } else {
          buckets[10 + digit].add(num);
        }
      }
      temp.clear();
      for (MyLinkedList<Integer> bucket : buckets) {
        temp.conjoin(bucket);
        bucket.clear();
      }
      curr++;
    }

    for (int i = 0; i < temp.size(); i++ ) {
      data[i] = temp.get(i);
    }

  }
  public static void main(String[] args) {
    int[] temp = new int[100];
    Random rand = new Random();
    for (int i =0; i < 100; i++) {
      temp[i] = rand.nextInt(10000);
    }
    radixsort(temp);
    System.out.println(Arrays.toString(temp));
  }


}
