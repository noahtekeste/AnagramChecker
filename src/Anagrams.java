/*
 * the following java program takes two string inputs and checks if
 * the strings are anagrams of each other
 * length of both stirngs should be between 1 and 50 inclusive
 *  
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the first String");
		String a = input.next();
		System.out.println("Enter the first String");
		String b = input.next();
			
		boolean result = isAnagram(a,b);
		System.out.println((result)?"Anagrams":"Not Anagrams");
	}//end of main
	
    static boolean isAnagram(String a, String b) {
        // Complete the function
        if((a.length()<1) || (a.length()>50) ||(b.length()<1) || (b.length()>50)){
			System.out.println("length of the strings shoule be between 1 and 50");
			System.exit(0);
		}
       if( a == null || b == null || a.equals("") || b.equals("") )
         throw new IllegalArgumentException();

       // initial quick test for non-anagrams
       if ( a.length() != b.length() )
	         return false;

       a = a.toLowerCase();
       b = b.toLowerCase();

       // populate a map with letters and frequencies of String b
       Map<Character, Integer> map = new HashMap<>();

       for (int k = 0; k < b.length(); k++){
    	   char letter = b.charAt(k);    

    	   if( ! map.containsKey(letter)){
    		   map.put( letter, 1 );
    	   } 
    	   else{
    		   Integer frequency = map.get( letter );
    		   map.put( letter, ++frequency );
    	   }
    }//end of for


	    for (int k = 0; k < a.length(); k++){
	    char letter = a.charAt(k);
	
	    if( ! map.containsKey( letter ) )
	        return false;
	
	    Integer frequency = map.get( letter );
	
	     if( frequency == 0 )
	        return false;
	    else    
	        map.put( letter, --frequency);
	    }
	
	    return true;
		
    }//end of isAnagram method
}//end of Anagrams class
