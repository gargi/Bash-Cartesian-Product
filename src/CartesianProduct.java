import java.util.ArrayList;

public class CartesianProduct {
	public String s;
	int i=0;	
	public CartesianProduct(String s) throws UnclosedBracket{
		if(!balancedBracket(s))
			throw new UnclosedBracket("Brackets not balanced in " + s);
		this.s = "{" + s + "}";
	}

	//method to check for valid parenthesis
	public boolean balancedBracket(String input) {  
		int i = 0;             
		for (char c : input.toCharArray()) {
			if (c == '{')
				i++;
			if (c == '}')
				i--;
			if(i < 0)
				return false;
		}
		return i == 0;
	}

	//returns the output in the form of a string
	public String getCartesianProduct(){
		StringBuilder sb=new StringBuilder();
		for (String i: getStrings()){
			sb.append(i).append(" ");
		}
		return sb.toString().trim();    //removes extra whitespace in the end
	}

	//Separates the strings based on braces
	public ArrayList<String> getStrings() {
		ArrayList<String> result = new ArrayList<>();
		ArrayList<String> temp;
		if (s.charAt(i) == '{') {
			i++;
			while (s.charAt(i-1) != '}') {
				temp = getStrings();
				result.addAll(temp);
				i++;
			}
			if (i == s.length()) {
				return result;
			}
			result = getElements(result);
		} 
		else {
			String literal = "";
			while (i < s.length() && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				literal += s.charAt(i);
				i++;
			}
			result.add(literal);
			result = getElements(result);
		}

		return result;
	}

	//Separates the elements inside the braces
	private ArrayList<String> getElements(ArrayList<String> result) {
		ArrayList<String> temp;
		while (i < s.length() && s.charAt(i) != ',' && s.charAt(i) != '}') {
			temp = getStrings();
			result = getProduct(result, temp);
		}
		return result;
	}

	//gets Cartesian Product
	private ArrayList<String> getProduct(ArrayList<String> resultList, ArrayList<String> tempList) {
		ArrayList<String> result = new ArrayList<>();
		for (String a: resultList) {
			for (String b : tempList) {
				result.add(a+b);
			}
		}
		return result;
	}

	public static void main(String args[]){
		try{
			if(args.length>0){				
				CartesianProduct product = new CartesianProduct(args[0]);
				System.out.println(product.getCartesianProduct());
			}
		}
		catch (UnclosedBracket e)   //check for valid parenthesis
		{
			e.printStackTrace();  
		}
		finally{
		}
	}
}

