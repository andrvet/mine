package binarytree.abr;



import java.util.LinkedList;

public class MainAbr {

    public static void main(String[] args) {
	
      //MyTreeAbr t = MyTreeAbr.makeTree(new int[]{1,2,3,4,5,6,7,8}, 0, 7);
      MyTreeAbr t2 = new MyTreeAbr(2, createLinkedList(new MyTreeAbr(8, createLinkedList(new MyTreeAbr(1)))));
      MyTreeAbr t6 = new MyTreeAbr(6, createLinkedList(new MyTreeAbr(7)));
      MyTreeAbr t4 = new MyTreeAbr(4, createLinkedList(new MyTreeAbr(10), t6, new MyTreeAbr(5)));
      MyTreeAbr t3 = new MyTreeAbr(3, createLinkedList(t4, new MyTreeAbr(9, createLinkedList(t2))));
      MyTreeAbr.printLevels(t3);
    }

  static <T> LinkedList<T> createLinkedList(T...elements) {
    LinkedList<T> newList = new LinkedList<T>();
    for (T el : elements) {
      newList.add(el);
    }

    return newList;
  }
}
