package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	Stack <Character> stuffs = new Stack <Character>();
    	for(Character c: b.toCharArray()) {
    		if(c.equals('{')) {
    			stuffs.push(c);
    		}
    		else if(c.equals('}')) {
    			if(stuffs.isEmpty()) {
    				return false;
    			}
    			else {
    			stuffs.pop();
    			}
    		}
    	}
    	if(stuffs.isEmpty()) {
        return true;
    	}
    	else {
    	return false;
    	}
    }
}