package assigment3;

class Automaton {
	public final static int MAX_DISPLAY_WIDTH = 121;
	public final static int DEFAULT_DISPLAY_WIDTH = 79;
	public final static String FIRST_GEN = "*";
	public final static String FIRST_EXTREME_BIT = " ";

	private static int j = 0;

	public boolean rules[]; // allocate rules[8] in constructor!
	public String thisGen; // same here
	private String extremeBit; // bit, "*" or " ", implied everywhere "outside"
	private int displayWidth; // an odd number so it can be perfectly centered

	// public constructors, mutators, etc. (need to be written)
	public Automaton(int rule) {
		setDisplayWidth(DEFAULT_DISPLAY_WIDTH);
		thisGen = FIRST_GEN;
		extremeBit = FIRST_EXTREME_BIT;
		rules = new boolean[8];
		// resetFirstGen();
		boolean b = setRule(rule);
		if (b == false) {
			setRule(0);
		}
		// setRule(rule);
	}

	// resets thisGen to firstGen
	// public void resetFirstGen()
	// {
	// thisGen = FIRST_GEN;
	// extremeBit = FIRST_EXTREME_BIT;
	// }

	public String decToBinary(int newRule) {
		String binString = Integer.toBinaryString(newRule);
		int remainderLength = 8 - binString.length();
		String zeros = new String(new char[remainderLength]).replace("\0", "0");
		binString = zeros + binString;
		return binString;
	}

	// inialize rules array based on newRule
	public boolean setRule(int newRule) {
		if (newRule < 0 || newRule > 255) {
			return false;
		}
		String binString = decToBinary(newRule);

		char[] binCharArray = binString.toCharArray();

		for (int i = 0; i < binCharArray.length; i++) {
			if (binCharArray[i] == '0') {
				rules[7-i] = false;
			} else {
				rules[7-i] = true;
			}
		}
		return true;
	}

	public boolean setDisplayWidth(int width) {
		if (width > MAX_DISPLAY_WIDTH) {
			return false;
		} else {
			displayWidth = width;
			return true;
		}
	}
	// output thisGen String of 80 symbols
	public String toStringCurrentGen() {
		// test values
		// thisGen = "abcdefg"; //TODO try with abcdefgh, abcdefghi, abcdefgij
		// displayWidth = 3; //always an odd number so it can be perfectly
		// centered

		// System.out.println("thisGen:"+thisGen);
		// System.out.println("displayWidth:"+displayWidth);
		// System.out.println("legth of thisGen:"+thisGen.length());
		String adjustedThisGen = "";
		if (thisGen.length() < displayWidth) {
			// System.out.println("thisGen is shorter than displayWidth:"+thisGen);
			int halfOfPadBits = (displayWidth - thisGen.length()) / 2;
			for (int i = 0; i < halfOfPadBits; i++) {
				adjustedThisGen = adjustedThisGen + extremeBit;
				
			}
			
			adjustedThisGen = adjustedThisGen + thisGen + adjustedThisGen;
					
			return adjustedThisGen;
		}

		/*
		 * substring (int beginIndex, int endIndex)
		 * 
		 * Returns a new string that is a substring of this string. The
		 * substring begins at the specified beginIndex and extends to the
		 * character at index endIndex - 1. Thus the length of the substring is
		 * endIndex-beginIndex. Examples:
		 * 
		 * "hamburger".substring(4, 8) returns "urge" "smiles".substring(1, 5)
		 * returns "mile"
		 * 
		 * Parameters:beginIndex the beginning index, inclusive. endIndex the
		 * ending index, exclusive.
		 * 
		 * Returns:the specified substring.
		 */
		int indexOfCentralChar = (thisGen.length() - 1) / 2;
		// System.out.println("index of middle char:"+indexOfCentralChar);
		// System.out.println("central char:"+thisGen.charAt(indexOfCentralChar));

		int startInderxOfRigthHalf = indexOfCentralChar + 1;
		// System.out.println("startInderxOfRigthHalf:"+startInderxOfRigthHalf);

		int endIndexOfRightHalth = (indexOfCentralChar + displayWidth / 2) + 1;
		String rightHalf = thisGen.substring(startInderxOfRigthHalf, endIndexOfRightHalth);
		// System.out.println("rightHalf:"+rightHalf);

		// LEFT portion
		int startInderxOfLeftHalf = (indexOfCentralChar - (displayWidth / 2));
		// System.out.println("startInderxOfLeftHalf:"+startInderxOfLeftHalf);

		int endIndexofLeftHalf = indexOfCentralChar;
		// System.out.println("endIndexofLeftHalf:"+endIndexofLeftHalf);

		String leftHalf = thisGen.substring(startInderxOfLeftHalf, endIndexofLeftHalf);
		// System.out.println("leftHalf:"+leftHalf);

		// char[] originalThisGenCharArray = thisGen.toCharArray();
		// find central element and truncate from both edges to be 80 symblos
		// width
		// for (int i = 0; i < originalThisGenCharArray.length - 1; i++)
		// {
		// if (i == (originalThisGenCharArray.length-1)/2) {
		// char centralChar = originalThisGenCharArray[i];
		// }
		// }

		adjustedThisGen = leftHalf + thisGen.charAt(indexOfCentralChar) + rightHalf;
		// System.out.println("adjustedThisGen:"+adjustedThisGen);
		return adjustedThisGen;
	}

	public char charToBin(char c) {
		if (c == '*')
			return '1';
		if (c == ' ')
			return '0';
		else
			return 'e';
	}

	public String strToBin(String c) {
		if ( c.equals("*") )
			return "1";
		if ( c.equals(" ") )
			return "0";
		else
			return "e";
	}

	public String boolToString(boolean b) {
		if (b)
			return "*";
		else
			return " ";
	}

	public void propagateNewGeneration() {
		
		String thisGenTemp = extremeBit + extremeBit + thisGen + extremeBit + extremeBit;
		//thisGen = extremeBit + extremeBit + thisGen + extremeBit + extremeBit;

		//System.out.println("j:" + j + "thisGen.length:" + thisGen.length());
		j++;
		char[] thisGenArray = thisGenTemp.toCharArray(); // {'0', '0', '1', '0', '0'}
		String nextGenElement = "";
		String nextGen = "";

		for (int i = 1; i <= thisGenArray.length - 2; i++) {

			char[] threeCharArray = new char[]{'u', 'p', 'f'};
			threeCharArray[0] = charToBin(thisGenArray[i - 1]);
			threeCharArray[1] = charToBin(thisGenArray[i]);
			threeCharArray[2] = charToBin(thisGenArray[i + 1]);
			String binString = new String(threeCharArray); // "001"
			int decInt = Integer.parseInt(binString, 2); // 1
			nextGenElement = boolToString(rules[decInt]); // string symbol for
															// rules[1]
			nextGen = nextGen + nextGenElement;
//			System.out.println("nextGen:" + nextGen);
		}

		thisGen = nextGen;

		String binExtremeBits = strToBin(extremeBit) + strToBin(extremeBit) + strToBin(extremeBit); // "xxx" -> "111"
		int decExtremeBits = Integer.parseInt(binExtremeBits, 2);
		extremeBit = boolToString(rules[decExtremeBits]);

		return;

	}
}
