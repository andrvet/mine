package mine;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

	
	    public ArrayList<String> letterCombinations(String digits) {
	        ArrayList<String> res = new ArrayList<String>();
	        ArrayList<String> preres = new ArrayList<String>();
	        res.add("");

	        for(int i=0;i<digits.length();i++){
	            for(String str: res) {
	                String letters /* "abc" */= map.get(digits.charAt(i)/* 2 */);
	                for(int j=0;j<letters.length();j++)
	                    preres.add(str+letters.charAt(j));
	            }
	            res = preres;
	            preres = new ArrayList<String>();
	        }      
	        return res;
	    }

	    static final HashMap<Character,String> map = new HashMap<Character,String>(){{
	        put('2',"abc");
	        put('3',"def");
	        put('4',"ghi");
	        put('5',"jkl");
	        put('6',"mno");
	        put('7',"pqrs");
	        put('8',"tuv");
	        put('9',"wxyz");
	    }} ;
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		ArrayList<String> r = s.letterCombinations("23");
		System.out.println(r);
	}

}
