package PSO;

public class try1 {
	public static String miroir(String input){
		
		String ret = "";
		for (int i= input.length(); i>0; i--) ret = ret + input.charAt(i-1) ; 

		return ret;
	}


	public static boolean palindrome(String input){

		String check = miroir(input);

		return input.equalsIgnoreCase(check);

	}
	public static void main(String[] args) {
		
		String example = "lellel";
		System.out.println(palindrome(example));
	}

}
