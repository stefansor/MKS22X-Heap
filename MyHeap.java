public class MyHeap{
  //node: n
  //parent: (n-1) / 2
  //children: 2n + 1 , 2n + 2

  //We discussed these 2 methods already:
  private static void pushDown(int[]data, int size, int index){
    int n = data[index];
    if(2 * index + 2 < size){
      if(n < data[2 * index + 2] && data[2 * index + 2] > data[2 * index + 1]){
        data[index] = data[2 * index + 2];
        data[2 * index + 2] = data[index];
        pushDown(data, size, 2 * index + 2);
      }
      else if(n < data[2 * index + 1]){
        data[index] = data[2 * index + 1];
        data[2 * index + 1] = data[index];
        pushDown(data, size, 2 * index + 1);
      }
    }
    else if(2 * index + 1 < size){
      if(n < data[2 * index + 1]){
        data[index] = data[2 * index + 1];
        data[2 * index + 1] = data[index];
        pushDown(data, size, 2 * index + 1);
      }
    }
  }
       //- size  is the number of elements in the data array.
       //- push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
       //- precondition: index is between 0 and size-1 inclusive
       //- precondition: size is between 0 and data.length-1 inclusive.

  //private static void pushUp(int[]data,int index)
       //- push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
       //- precondition: index is between 0 and data.length-1 inclusive.


  //We will discuss this today
  //public static void heapify(int[])
      //- convert the array into a valid heap. [ should be O(n) ]

  //public static void heapsort(int[])
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
    HeapPrinter.print(ary);
    //nothing should happen as all of the elements are already ordered
    //with the root as the max
    //edited the array to have an error in index 2 and pushDown should correct it

  }

}
