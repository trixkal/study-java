
import java.util.Stack;

/* Codility Lesson 7-1 Brackets 
 * @author Richard Kavanagh 
 */
public class Brackets {

	public static void main(String[] args) {
		//String input = "{[()()]}";
		String input = "(A)";
		int result = solution(input);
		System.out.println(result);
	}

	
	    public static int solution(String S) {

	        // main idea: use "Stack" (push and pop)
	        
	        //special case
	        if(S.length() == 0)
	            return 1;
	        
	        // new Stack<Character>()
	        Stack<Character> stack = new Stack<>();
	        // scan the string (just one pass)
	        for(int i=0; i< S.length(); i++){
	            // note: push "its pair"
	            if( S.charAt(i) == '(' ){
	                //System.out.println(stack.push(')'));
	            	stack.push(')');
	            }
	            else if( S.charAt(i) == '[' ){
	                stack.push(']');
	            }
	            else if( S.charAt(i) == '{' ){
	                stack.push('}');
	            }
	            // pop and check
	            else if( S.charAt(i) == ')' || S.charAt(i) == ']' || S.charAt(i) == '}'){
	                // important: check if the stack is empty or not (be careful)
	                if(stack.isEmpty() == true){
	                    return 0;
	                }
	                else{
	                    char temp = stack.pop(); // check if the stack is empty before pop!!!
	                    if(temp != S.charAt(i)){ // not a pair
	                        return 0;
	                    }
	                }
	            }
	        }
	        // note: check if the stack is empty or not (be careful)
	        if( !stack.isEmpty() ){
	            return 0;
	        }
	        else{
	            return 1;
	        }
	    }

}
