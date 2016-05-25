package factory.design.pattern;

/*
 * LinkedList and ArrayList both implement List Interface but how they work internally is where the differences lies.
 *  MainAbr difference between ArrayList and LinkedList is that 
 *  ArrayList is implemented using __re sizable array 
 *  while LinkedList is implemented using __doubly LinkedList.
 *  
 *   ArrayList is more popular among Java programmer than LinkedList as there are few scenarios on which LinkedList is a suitable collection than ArrayList
 *   
 *   
 *   1) Since Array is an index based data-structure 
 *   *****searching or getting element from Array with index is pretty fast. 
 *   Array provides O(1) performance for get(index) method but 
 *   ****remove is costly in ArrayList as you need to rearrange all elements. 
 *   
 *   On the Other hand LinkedList doesn't provide Random or index based access 
 *   and you need to iterate over linked list to retrieve any element which is of order O(n).

2) ***Insertions  are easy and fast in LinkedList as compared to ArrayList because there is no risk of resizing array
and copying content to new array if array gets full which makes adding into ArrayList of O(n) in worst case, 
while adding is O(1) operation in LinkedList in Java. 
ArrayList also needs to update its index if you insert something anywhere except at the end of array.

3) ***Removal is like insertions better in LinkedList than ArrayList.

4) LinkedList has more memory overhead than ArrayList because in ArrayList each index only holds actual object (data) 
but in case of LinkedList each node holds both data and address of next  and previous node.

***************
*
*LinkedList is not as popular as ArrayList but still there are situation where a LinkedList is better choice than ArrayList in Java. 
*
*Use LinkedList in Java if:

1) Your application can live without Random access. 
Because if you need nth element in LinkedList you need to first traverse up to nth element O(n) and than you get data from that node.

2) Your application is more insertion and deletion driver and you insert or remove more than retrieval. Since insertion or
removal doesn't involve resizing its much faster than ArrayList.


Read more: http://javarevisited.blogspot.com/2012/02/difference-between-linkedlist-vs.html#ixzz3x9dOsWlt



 */
public class LinkedListVsArrayList {

}
