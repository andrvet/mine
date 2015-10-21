package mine;

public class HighestProduct {

	static int getHighestProductOfThree(int[] arr) {
		if (arr.length < 3) {
			throw new IllegalArgumentException("Must be 3 elements");
		}

		int highest = Math.max(arr[0], arr[1]);
		int lowest = Math.min(arr[0], arr[1]);

		int highestProductOfTwo = arr[0] * arr[1];
		int lowestProductOfTwo = arr[0] * arr[1];
		int highestProductOfThree = arr[0] * arr[1] * arr[2];

		for (int current : arr) {
			if (current == 0) {
				return highestProductOfThree;
			}
			highestProductOfThree = Math.max( highestProductOfThree, Math.max(current * highestProductOfTwo, current * lowestProductOfTwo));
			highestProductOfTwo = Math.max(highestProductOfTwo, Math.max(current * highest, current * lowest));
			lowestProductOfTwo = Math.min(lowestProductOfTwo, Math.min(current * highest, current * lowest));

			highest = Math.max(highest, current);
			lowest = Math.min(lowest, current);
		}

		return highestProductOfThree;
	}

	public static void main(String[] args) {
	
		/*
		 * highest_product_of_3([-200,-200,12,12,44,345,123,1]); -200 * -200 * 345 = 13800000
		 */
		int[] arr1 = new int[] {-200,-200,12,12,44,345,123,1};
		int hp1 = getHighestProductOfThree(arr1);
		System.out.println(hp1);
		
		//TODO process 0. must be 600
		int[] arr2 = new int[] { 10, 3, 0, -2, 12, 5, 1, 1, 4 };
		int hp2 = getHighestProductOfThree(arr2);
		System.out.println(hp2);

	}

}
