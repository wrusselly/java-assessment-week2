package main;

import static org.junit.Assert.assertFalse;

public class OfflineExercises {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") → "TTThhheee"
	// multChar("AAbb") → "AAAAAAbbbbbb"
	// multChar("Hi-There") → "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String str = "";
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < 3; j++) {
				str = str + input.charAt(i);
			}
			
		}
		
		return str;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") → "evilc"
	// getBert("xxbertfridgebertyy") → "egdirf"
	// getBert("xxBertfridgebERtyy") → "egdirf"
	// getBert("xxbertyy") → ""
	// getBert("xxbeRTyy") → ""

	public String getBert(String input) {
		input = input.toLowerCase();
		String output = "";
		String str = "";
		int first = input.indexOf("bert");
		if (first != -1) {
			str = input.substring(first + 4);
		}
		int last = str.lastIndexOf("bert");
		if (last != -1) {
			str = str.substring(0, last);
		}
		if (last == -1) {
			output = "";
		}
		else {
			for (int i = 0; i < str.length(); i++) {
				output = output + str.charAt(str.length()-i-1);
			}
		}
		
		
		return output;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false
	// evenlySpaced(4, 60, 9) → false

	public boolean evenlySpaced(int a, int b, int c) {
		int d = 0;
		int e = 0;
		int f = 0;
		boolean output = false;
		
		if (a<b) {
			if (a<c) {
				d=a;
				if (b<c) {
					e=b;
					f=c;
				}
				else {
					e=c;
					f=b;
				}
			}
			else {
				d=c;
				e=a;
				f=b;
			}
		}
		else {
			if (a<c) {
				e=a;
				d=b;
				f=c;
			}
			else {
				f=a;
				if (b<c) {
					d=b;
					e=c;
				}
				else {
					d=c;
					e=b;
				}
			}
		}
		
		if((e-d)==(f-e)) {
			output = true;
		}
		
		return output;
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) → "Ho"
	// nMid("Chocolate", 3) → "Choate"
	// nMid("Chocolate", 1) → "Choclate"

	public String nMid(String input, int a) {
		for (int i = 0; i < a; i++) {
			input = input.substring(0, input.length()/2) + input.substring((input.length()/2)+1, input.length());
		}
		
		return input;
	}

	// Given a string, return true if it ends in "dev". Ignore Case

	// endsDev("ihatedev") → true
	// endsDev("wehateDev") → true
	// assertFalse(oe.endsDev("jh"));
	// endsDev("everoyonehatesdevforreal") → false
	// endsDev("devisnotcool") → false

	public boolean endsDev(String input) {
		input = input.toLowerCase();
		boolean output = false;
		if (input.length()>2) {
			input = input.substring(input.length()-3);
			if (input.indexOf("dev") != -1) {
				output = true;
			}
		}
		
		return output;
	}



	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") → 2
	// superBlock("abbCCCddDDDeeEEE") → 3
	// superBlock("") → 0

	public int superBlock(String input) {
		int count = 0;
		int max = 0;
		if (input == "") {
			max = 0;
		}
		else if (input.length() == 1){
			max = 1;
		}
		else {
			for (int i = 0; i < input.length()-1; i++) {
				if (input.charAt(i)==input.charAt(i+1)) {
					count++;
					if (count > max ) {
						max = count;
					}	
				}
				else {
					count = 1;
					}	
				}
		}
		
		return max;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") → 1
	//amISearch("I am in Amsterdam am I?") → 2
	//amISearch("I have been in Amsterdam") → 0

	public int amISearch(String arg1) {
		int x = 0;
		int count = -1;
		arg1 = arg1.toLowerCase();
		arg1 = " " + arg1 + " ";
		
		while (x != -1) {		
			x = arg1.indexOf(" am ");
			arg1 = arg1.substring(x+3);
			count++;
			
		}
		
		return count;
		
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) → "fizz"
	//fizzBuzz(10) → "buzz"
	//fizzBuzz(15) → "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		String output = "";
		if (arg1%3 == 0) {
			output = output + "fizz";
		}
		if (arg1%5 == 0) {
			output = output + "buzz";
		}

		return output;
		
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
	//largest("55 72 86") → 14
	//largest("15 72 80 164") → 11
	//largest("555 72 86 45 10") → 15
	
	public int largest(String arg1) {
		String[] str = arg1.split(" ");
		int[] ints = new int[str.length];
		
		for (int i = 0; i < str.length; i++) {
			int total = 0;
			for (int j = 0; j < str[i].length(); j++) {
				if (str[i].charAt(j) == '1') {
					total +=1;
				}
				if (str[i].charAt(j) == '2') {
					total +=2;
				}
				if (str[i].charAt(j) == '3') {
					total +=3;
				}
				if (str[i].charAt(j) == '4') {
					total +=4;
				}
				if (str[i].charAt(j) == '5') {
					total +=5;
				}
				if (str[i].charAt(j) == '6') {
					total +=6;
				}
				if (str[i].charAt(j) == '7') {
					total +=7;
				}
				if (str[i].charAt(j) == '8') {
					total +=8;
				}
				if (str[i].charAt(j) == '9') {
					total +=9;
				}
			}
			ints[i] = total;
		}
		
		int max = 0;
		for (int i = 0; i < ints.length-1; i++) {
			max = ints[0];
			if(ints[i]<ints[i+1]) {
				max = ints[i+1];
			}
			if(ints[ints.length-2] < ints[ints.length-1]) {
				max = ints[ints.length-1];
			}
		}
		return max;
		
	}
	
	
}
