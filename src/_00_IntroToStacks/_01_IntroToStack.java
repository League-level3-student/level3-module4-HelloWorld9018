package _00_IntroToStacks;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import javax.swing.JOptionPane;

public class _01_IntroToStack {
	static ArrayList <Double> myDoubles = new ArrayList<Double>();
    public static void main(String[] args) {
    	duoInputPanel duoInput = new duoInputPanel("Input", "", "Enter two numbers between [0, 100]", "Enter");
    	
    }
    
    static void doStuff(int n1, int n2) {
        // 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class
    	Stack<Double> doubles = new Stack<Double>();
        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
    	for(int i = 0; i<=100; i++) {
    		Double ranD = new Random().nextDouble()*100; //how to set parameters from 0 to 100?
    		doubles.push(ranD);
    	}
        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
    	
    	
    	System.out.println(n1 + ", " + n2);
 
        // 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.
    	
    	while(!doubles.isEmpty()) {
    	myDoubles.add(doubles.pop());
    	}
    	
    	for(int i = 0; i <=100; i++) {
    		if(myDoubles.get(i)>n1 & myDoubles.get(i)<n2 || myDoubles.get(i)<n1 & myDoubles.get(i)>n2) {
    			System.out.println(myDoubles.get(i));
    		}
    	}

        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
    }
}
