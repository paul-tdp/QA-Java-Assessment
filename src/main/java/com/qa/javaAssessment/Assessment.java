package com.qa.javaAssessment;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.StringBuilder;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {
		String lower = input.toLowerCase();
        String pattern1 = "bert";
        String pattern2 = "bert";
        Pattern p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
        Matcher m = p.matcher(lower);
        String solution = "";
        while (m.find()) {
            solution = new StringBuilder(m.group(1)).reverse().toString();
          }
		return solution;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		boolean solution = (a - b == b - c) || (a - c == c - b) || (a - b == c - a);
		return solution;
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		StringBuilder text = new StringBuilder(input);
		for (int i = 0; i < a; i++) {
			text.deleteCharAt(text.length() / 2);
		}
		String solution = text.toString();
		return solution;
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			int tempCount = 0;
			for (int j = i; j < input.length(); j++) {
				if (input.charAt(i) == input.charAt(j)) {
					tempCount++;
				}
				else {
					break;
				}
			}
			if (tempCount > count) {
				count = tempCount;
			}
		}
		return count;
	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		String arr[] = arg1.toLowerCase().split(" ");
		int solution = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].equals("am")) {
				solution++;
			}
		}
		return solution;
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		String solution = "";
		if(arg1 % 3 == 0 && arg1 % 5 == 0) {
			solution = "fizzbuzz";
		}
		else if(arg1 % 3 == 0) {
			solution = "fizz";
		}
		else if(arg1 % 5 == 0) {
			solution = "buzz";
		}
		return solution;
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		int max = 0;
	    String arr[] = arg1.split(" ");
	    for(int i = 0; i < arr.length; i++) {
	    	String val = arr[i].toString();
	    	int charLength = 0;
	    	for(int j = 0; j < val.length(); j++) {
	    		String strNum = Character.toString(val.charAt(j));
	    		int numVal = Integer.parseInt(strNum);
	    		charLength = charLength + numVal;
	    	}
	    if(charLength > max) {
	    max = charLength;
	    }
	    }
	    return max;
	  }
}
