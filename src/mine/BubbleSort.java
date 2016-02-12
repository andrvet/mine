package mine;

import java.util.Arrays;

/*
 * In Bubble sort algorithm we sort an unsorted array by starting from first element 
 * and comparing with adjacent element. If former is greater than later then we swap 
 * and by doing this we get the largest number at the end after first iteration. 
 * So in order to sort n elements you require n-1 iteration and almost n-1 comparison. 
 * 
   For recap here is the logic for bubble sort sorting algorithm :

1) start comparing a[0] to a[1]
2) if a[0] > a[1] then swap numbers e.g. a[0]=a[1] and a[1]=a[0]
3) compare a[1] to a[2] and repeat till you compare last pair
4) This is referred as one pass and at the end of first pass largest number is at last
5) repeat this comparison again starting from a[0] but this time going till second last pair only


Read more: http://java67.blogspot.com/2012/12/bubble-sort-in-java-program-to-sort-integer-array-example.html#ixzz3x7TpStaU

 */
/**
 * Java program to sort integer array using bubble sort sorting algorithm.
 * bubble sort is one of the simplest sorting algorithm but performance
 * of bubble sort is not good, its average and worst case performance
 * ranges in O(n2) and that's why it is not used to sort large set of
 * unsorted data. Bubble sort can be used for educational and testing
 * purpose to sort small number of data to avoid performance penalty. 
 * This program is also a good example of how to print contents of Array in Java
 *
 * @author 
 */
public class BubbleSort {
  
  
    public static void main(String args[]) {
        //testing our bubble sort method in Java
        int[] unsorted = {32, 39,21, 45, 23, 3};
        bubbleSort(unsorted);
      
        //one more testing of our bubble sort code logic in Java
        int[] test = { 5, 3, 2, 1};
        bubbleSort(test);
      
    }   
  
    /*
     * In bubble sort we need n-1 iteration to sort n elements
     * at end of first iteration larget number is sorted and subsequently numbers smaller
     * than that.
     */
    public static void bubbleSort(int[] unsorted){
        System.out.println("unsorted array before sorting : " + Arrays.toString(unsorted));
      
        // Outer loop - need n-1 iteration to sort n elements
        for(int i=0; i<unsorted.length-1; i++){
          
            //Inner loop to perform comparision and swapping between adjacent numbers
            //After each iteration one index from last is sorted
            for(int j= 1; j<unsorted.length-i; j++){
              
                //If current number is greater then swap those two
                if(unsorted[j-1] > unsorted[j]){
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j-1];
                    unsorted[j-1] = temp;
                }
            }
            System.out.printf("unsorted array after %d pass %s: %n", i+1, Arrays.toString(unsorted));
        }
    }

}

//Output:
//unsorted array before sorting : [32, 39, 21, 45, 23, 3]
//unsorted array after 1 pass [32, 21, 39, 23, 3, 45]:
//unsorted array after 2 pass [21, 32, 23, 3, 39, 45]:
//unsorted array after 3 pass [21, 23, 3, 32, 39, 45]:
//unsorted array after 4 pass [21, 3, 23, 32, 39, 45]:
//unsorted array after 5 pass [3, 21, 23, 32, 39, 45]:
//unsorted array before sorting : [5, 3, 2, 1]
//unsorted array after 1 pass [3, 2, 1, 5]:
//unsorted array after 2 pass [2, 1, 3, 5]:
//unsorted array after 3 pass [1, 2, 3, 5]
//
