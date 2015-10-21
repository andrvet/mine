package processTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//luna
/*	
 Input: This table represents the ‘data table’, where PID indicates the parent element. 
 For example, in the first row we see that A has PID null whereas B has PID 0, which means that B’s parent is A, 
 because 0 is the ID of A, and A is the root element, because it does not have a PID. 
 Similarly, C has parent A because C too has PID 0, and 0 is the ID of A. 

 You will need to provide your own class definition for DataTable.

 PID column represents a parent of an element.
 ID	Name PID
 0 	A 	NULL 	A's PID is NULL => A is a root element; A has no parent
 1 	B 	0    	B's pid is 0 => B is a child of A;    
 2 	C 	0    	C's pid is 0 => C is a child of A (A is a parent of C) 
 4 	D 	1    	D is a child of B
 5 	E 	1    	E is a child of B
 6 	F 	4    	F is a child of D
 3 	G 	0    	G is a child of A

 */

public class ProcessTable {

	static List<String> childrenOfA = new ArrayList<String>();
	static List<String> childrenOfB = new ArrayList<String>();
	static List<String> childrenOfC = new ArrayList<String>();
	static List<String> childrenOfD = new ArrayList<String>();
	static List<String> childrenOfE = new ArrayList<String>();
	static List<String> childrenOfF = new ArrayList<String>();
	static List<String> childrenOfG = new ArrayList<String>();
	
	static List<String> descendantsOfA = new ArrayList<String>();
	static List<String> descendantsOfB = new ArrayList<String>();
	static Map<String, List<String>> hm = new HashMap<String, List<String>>();

	public static Map<String, List<String>> processDataTable() {

		Map<String, List<String>> hm = new HashMap<String, List<String>>();

		hm.put("A", descendantsOfA);
		hm.put("B", descendantsOfB);
		hm.put("C", childrenOfC);
		hm.put("D", childrenOfD);
		hm.put("E", childrenOfE);
		hm.put("F", childrenOfF);
		hm.put("G", childrenOfG);
	
		System.out.println("Output:");
		for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		return null;

	}

	public static void main(String... arg) {

		ArrayList<Row> dataTable = createTable();
		printTable(dataTable);

		createListOfChildrenForEachNode(dataTable);
		printChildrenOfAllNodes();

		hm = processDataTable();
		
	}
/*
 * print children of each node to check the correctness
 */
	private static void printChildrenOfAllNodes() {
		printChildrenOfNode("A", childrenOfA);
		printChildrenOfNode("B", childrenOfB);
		printChildrenOfNode("C", childrenOfC);
		printChildrenOfNode("D", childrenOfD);
		printChildrenOfNode("E", childrenOfE);
		printChildrenOfNode("F", childrenOfF);
		printChildrenOfNode("G", childrenOfG);
	}

	/*
	 * iterate through each row in the dataTable and create lists of children
	 * for each node
	 */
	private static void createListOfChildrenForEachNode(ArrayList<Row> dataTable) {

		for (Row row : dataTable) {

			// if pid in a row is null there are no children so just continue
			if (row.pid == null)
				continue;

			// create list of children of node A
			if (row.pid == 0) {
				childrenOfA.add(row.name);
			}
			// create list of children of node B etc
			else if (row.pid == 1) {
				childrenOfB.add(row.name);
			} else if (row.pid == 2) {
				childrenOfC.add(row.name);
			} else if (row.pid == 3) {
				childrenOfG.add(row.name);
			} else if (row.pid == 4) {
				childrenOfD.add(row.name);
			} else if (row.pid == 5) {
				childrenOfE.add(row.name);
			} else if (row.pid == 6) {
				childrenOfF.add(row.name);
			} else
				continue;
		}
		
		
		
		descendantsOfA.addAll(childrenOfA);
		descendantsOfA.addAll(childrenOfB);
		descendantsOfA.addAll(childrenOfD);
		
		descendantsOfB.addAll(childrenOfB);
		descendantsOfB.addAll(childrenOfD);
	}

	/*
	 * print rows from the table to check it was filled in correctly
	 */
	private static void printTable(ArrayList<Row> dataTable) {
		System.out.println("Input table:");
		for (Row row : dataTable) {
			System.out.println(row.id + " - " + row.name + " - " + row.pid);
		}
	}

	private static ArrayList<Row> createTable() {
		// We could use Binary Tree with node A as a root but the root A has
		// three children (B,C and G)
		// We could use a tree with three children but for simplicity I use just
		// an ArrayList of rows as a type for data table
		ArrayList<Row> dataTable = new ArrayList<Row>();
		dataTable.add(new Row(0, "A", null));
		dataTable.add(new Row(1, "B", 0));
		dataTable.add(new Row(2, "C", 0));
		dataTable.add(new Row(4, "D", 1));
		dataTable.add(new Row(5, "E", 1));
		dataTable.add(new Row(6, "F", 4));
		dataTable.add(new Row(3, "G", 0));
		return dataTable;
	}

	private static void printChildrenOfNode(String node,
			List<String> listOfChildren) {
		System.out.print("children of node " + node + ": ");
		for (String child : listOfChildren) {
			System.out.print(child + " ");
		}
		System.out.println();
	}

}
