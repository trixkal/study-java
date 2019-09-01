package trixkal.study.java;

import java.util.Stack;

/*A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class BalancedString { public boolean solution(String S); }

that, given a string S consisting of N characters, returns true if S is properly nested and false otherwise.
For example, given S = "{[()()]}", the function should return true and given S = "([)()]", the function should return false, as explained above.
Write an efficient algorithm for the following assumptions:
*/

public class BalancedString {

	public static void main(String[] args) {
		String caseEmpty = "";
		String caseOne = "(U)";
		String caseTwo = "VW";
		String caseThree = "{[()()]}";
		String caseFour = "([)()]";
		String caseFive = "[(UA)ROC()]";
		String caseSix = "[(PA)AND)]";
		System.out.println("caseEmpty "+solution(caseEmpty));
		System.out.println("caseOne "+solution(caseOne));
		System.out.println("caseTwo "+solution(caseTwo));
		System.out.println("caseThree "+solution(caseThree));
		System.out.println("caseFour "+solution(caseFour));
		System.out.println("caseFive "+solution(caseFive));
		System.out.println("caseSix "+solution(caseSix));
	}
	
	public static boolean solution (String evalString) {
		if (evalString.length()<=0)
			return true;
		if (!evalString.contains("{") && !evalString.contains("}") 
				&& !evalString.contains("(") && !evalString.contains(")")
				&& !evalString.contains("[") && !evalString.contains("]")) 
			return true;
		Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < evalString.length(); i++) {
            char c = evalString.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {     
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }           
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
		
		return true;
	}

}
