package mine;


public class PhoneCombine {
	
	private String[] phoneBookCodes = { ""/*1*/, "ABC" /*2*/, "DEF"/*3*/, "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

	private void generateCombinations(int[] a, int i, StringBuffer sb) {
		if (i == a.length) {
			// Print the combination...
			System.out.println(sb.toString()); // Workaround.
			return;
		}

//		if (a[i] == 0 || a[i] == 1) {
//			sb.append(" ");
//			generateCombinations(a, i + 1, sb);
//			sb = sb.delete(i, sb.length());
//		} else 
//		{
		   //i=0; a[0]=2; x=book[1]=abc
			String x = phoneBookCodes[a[i] - 1];

			for (int j = 0; j < x.length(); j++) {
				sb.append(x.charAt(j));
				generateCombinations(a, i + 1, sb);
				sb = sb.delete(i, sb.length());
			}
//		}

	}

	public static void main(String[] args) {
		int[] a = { 2,3 };
		//ad, ae, af
		//bd, be, bf
		//cd, ce, cf

		PhoneCombine pbc = new PhoneCombine();
		
		StringBuffer sb = new StringBuffer();

		pbc.generateCombinations(a, 0, sb);
		
	}

}