package mine;

import java.util.Scanner;
/**
 * This Java program takes an input number from command line and integer array
 * and check if number is palindrome or not. A number is called palindrome
 * if number is equal to reverse of number itself.
 * 
Division operator can be used to get rid of last digit e.g. 1234/10 will give you 123, 
and modulus operator can give you last digit e.g. 1234%10 will return 4
  */
public class PalindromeTest {
  
  
    public static void main(String args[]){
      
        Scanner scanner = new Scanner(System.in);       
        //int number = scanner.nextInt();
        int[] numbers = {1, 20, 22, 102, 101, 1221, 13321, 13331, 0, 11};
      
        for(int number: numbers){
            System.out.println("Is number :" + number + " a palindrome? " + isPalindrome(number));
        }             
    }

    private static boolean isPalindrome(int number) {
    	
        if(number == reverse(number)){
            return true;
        }
        return false;
    }
  
      
    private static int reverse(int number){
        int reverse = 0;
      
//        via Devision - Get rid of last digit => 1234 / 10 will give you 123, 
//        via Modulus - get last digit => 1234 % 10 will return 4
        		
        while(number != 0){
        	
          reverse = reverse*10 + number%10; 
          number = number/10;
        }
              
        return reverse;
    }

}

//Output
//Does number : 1 is a palindrome? true
//Does number : 20 is a palindrome? false
//Does number : 22 is a palindrome? true
//Does number : 102 is a palindrome? false
//Does number : 101 is a palindrome? true
//Does number : 1221 is a palindrome? true
//Does number : 13321 is a palindrome? false
//Does number : 13331 is a palindrome? true
//Does number : 0 is a palindrome? true
//Does number : 11 is a palindrome? true
