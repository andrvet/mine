package mine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSortedListsGood {

	public static List<Integer> collateSortedLists(List<Integer> l1,
			List<Integer> l2) {
	
		List<Integer> result = new ArrayList<Integer>();
		result.addAll(l1);
		result.addAll(l2);

		Collections.sort(result);

		return result;

	}

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<Integer>();
		// 0,2,3,
		list1.add(0);
		list1.add(2);
		list1.add(3);
		// 1,3,4,5
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(3);
		list1.add(4);
		list1.add(5);

		List<Integer> result = collateSortedLists(list1, list2);
		// 0,1,2,3,3,4,5
		for (Integer r : result) {
			System.out.println(r);
		}
	}

}
