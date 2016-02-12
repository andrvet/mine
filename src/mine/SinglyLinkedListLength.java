package mine;

public class SinglyLinkedListLength {

	// Linked lists is last element will point to "null" element ,
	// so I will use a counter and increment till we reach the end of the
	// element

	// Iterative Solutions

	public int length(){
		int count=0;
		Node current = this.head;
	
		while(current != null){
		count++;
		current=current.next()
		} 
		return count;
	}
	
	// Recursive Solution:

	public int length(Node current) {
		if (current == null) // base case
			return 0;

		return 1 + length(current.next());
	}

}


//TODO

//Question 9 : How do you find duplicates in array if there is more than one duplicate?
//Answer: using a Hashtable or HashMap. 
//Traverse through array, and store each number as key and number of occurrence as value. 
//At the end of traversal you can find all duplicate numbers, for which occurrence is more than one. 
//In Java if a number already exists in HashMap then calling get(index) will return number otherwise it return null. 
//This property can be used to insert or update numbers in HashMap.

//TODO
//Binary Search Tree has some special properties e.g. 
//left nodes contains items whose value is less than root , 
//right sub tree contains keys with higher node value than root, 
//and there should not be any duplicates in the tree.

//TODO
//Question 14 : How to reverse linked list using recursion and iteration?

