import java.util.*;

public class MyHeap{
  //node: n
  //parent: (n-1) / 2
  //children: 2n + 1 , 2n + 2

  //We discussed these 2 methods already:
  private static void pushDown(int[]data, int size, int index){
    int n = data[index];
    if(2 * index + 1 < size){
      if(n < data[2 * index + 1] && data[2 * index + 1] > data[2 * index + 2]){
        data[index] = data[2 * index + 1];
        data[2 * index + 1] = n;
        pushDown(data, size, 2 * index + 1);
      }
      else if(n < data[2 * index + 2]){
        data[index] = data[2 * index + 2];
        data[2 * index + 2] = n;
        pushDown(data, size, 2 * index + 2);
      }
    }
    else if(2 * index + 2 < size){
      if(n < data[2 * index + 2]){
        data[index] = data[2 * index + 2];
        data[2 * index + 2] = n;
        pushDown(data, size, 2 * index + 2);
      }
    }
  }
       //- size  is the number of elements in the data array.
       //- push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
       //- precondition: index is between 0 and size-1 inclusive
       //- precondition: size is between 0 and data.length-1 inclusive.

  private static void pushUp(int[]data,int index){
    int n = data[index];
    if((index - 1) / 2 > 0){
      if(data[(index - 1) / 2] < n){
        data[index] = data[(index - 1) / 2];
        data[(index - 1) / 2] = n;
        pushUp(data, (index - 1) / 2);
      }
    }
  }
       //- push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
       //- precondition: index is between 0 and data.length-1 inclusive.


  //We will discuss this today
  public static void heapify(int[] data){
    //- convert the array into a valid heap. [ should be O(n) ]
    for (int i = data.length / 2; i >= 0; i--) {
      pushDown(data, data.length, i);
    }
  }


//should remove the root of the tree and push the next appropriate max
//swap max and min then remove the last item (should be the max) then push down root
//precondition: data is heapified
//size is num of elements in array
//does not actual remove elements of the arry however it does sort sort of
  public static int remove(int[] data, int size){
    int num = data[0];
    data[0] = data[size - 1];
    data[size - 1] = num;
    pushDown(data, size - 1, 0);
    return num;
  }


  public static void heapsort(int[] data){
    heapify(data);
    for(int i = 0; i < data.length; i++){
      remove(data, data.length - i);
    }
  }
      //- sort the array [ should be O(nlogn) ] :
      // converting it into a heap
      //removing the largest value n-1 times (remove places at end of the sub-array).




  public static void main(String[] args){
    int[] ary = new int[]{
      43, 34, 2, 22, 33, 12, 13, 10, 9
    };
    HeapPrinter.print(ary);
    pushDown(ary, ary.length, 2);
    System.out.println();
    System.out.println();

    HeapPrinter.print(ary);
    System.out.println();
    System.out.println();

    //nothing should happen as all of the elements are already ordered
    //with the root as the max
    //edited the array to have an error in index 2 and pushDown should correct it

    //testing heapify
    int[] yea = new int[]{
      34, 3, 4,5, 23, 5,6, 67, 24
    };
    HeapPrinter.print(yea);
    pushUp(yea, 6);
    System.out.println();
    System.out.println();
    HeapPrinter.print(yea);


    heapify(yea);
    System.out.println();
    System.out.println();

    HeapPrinter.print(yea);
    System.out.println();
    for(int i = 0; i < yea.length; i++){
      System.out.println(remove(yea, yea.length - i));
       System.out.println(Arrays.toString(yea));

    }
    //System.out.println(Arrays.toString(yea));
    //heapsort(yea);
    //System.out.println(Arrays.toString(yea));


  }

}
