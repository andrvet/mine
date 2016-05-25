package mine;

public class HelloWorld {

	public static void main(String[] args) {

		//int[] arr = {2, 1, 2, 3, 2, 3, 4, 1};
		int[] arr = {2,3,4,3,2,1,2,1,2,3,4,5,4,3,4,5};
		int s = 5;

		// Travers the given array starting from
		// leftmost element
		int i = 0,j=0;
		while (i < arr.length) {
			System.out.println("j:"+j++);//just print each iteration
			// If s is found at index i
			if (arr[i] == s) {
				System.out.println("found i:" + i);
				break;
			}

			// Jump the difference between current
			// array element and s
			i = i + Math.abs(arr[i] - s);
		}

		//System.out.println("not found");
	}

}
