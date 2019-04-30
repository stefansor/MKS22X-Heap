import java.util.*;

public class MyHeap{
  //node: n
  //parent: (n-1) / 2
  //children: 2n + 1 , 2n + 2

  //We discussed these 2 methods already:
  private static void pushDown(int[]data, int size, int index){
    int n = data[index];
    if(2 * index + 2 < size){
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
    else if(2 * index + 1 < size){
      if(n < data[2 * index + 1]){
        data[index] = data[2 * index + 1];
        data[2 * index + 1] = n;
        pushDown(data, size, 2 * index + 1);
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
          System.out.println("Size\t\tMax Value\theap/builtin ratio ");
        int[]MAX_LIST = {1000000000,500,10};
        for(int MAX : MAX_LIST){
          for(int size = 31250; size < 2000001; size*=2){
            long qtime=0;
            long btime=0;
            //average of 5 sorts.
            for(int trial = 0 ; trial <=5; trial++){
              int []data1 = new int[size];
              int []data2 = new int[size];
              for(int i = 0; i < data1.length; i++){
                data1[i] = (int)(Math.random()*MAX);
                data2[i] = data1[i];
              }
              long t1,t2;
              t1 = System.currentTimeMillis();
              MyHeap.heapsort(data2);
              t2 = System.currentTimeMillis();
              qtime += t2 - t1;
              t1 = System.currentTimeMillis();
              Arrays.sort(data1);
              t2 = System.currentTimeMillis();
              btime+= t2 - t1;
              if(!Arrays.equals(data1,data2)){
                System.out.println("FAIL TO SORT!");
                System.exit(0);
              }
            }
            System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
          }
          System.out.println();
        }

        }

}
