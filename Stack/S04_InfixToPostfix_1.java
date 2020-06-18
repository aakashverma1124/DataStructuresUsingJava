/*	
	@author
	Aakash.Verma

	In this particular code, we'll be using inbuilt Stack Class because you are already familiar with
	the procedure that Stack works.

	Problem: Given an infix expression, the task is to convert it into the respective postfix expression.

	For example:

	Input: InfixExpression = "+b*c+d"
	Output: abc*+d+

	Input: InfixExpression = "a*b+c%d-e"
	Output: ab*cd%+e-

	Approach:

	1. We'll iterate over the infixExpression.
	2. For every symbol(character), we check whether the symbol is operator or operand.
	3. If the symbol is operand, append it to the postfixExpression.
	4. If the symbol is operator.
		1. If stack is not empty and the operator which is at the top of the stack is of 
		higher precendence than the current symbol(operator), then pop the element from the stack
		and add it to the postfixExpression.
		2. If stack is empty, simply push the current symbol to the stack.
	5. If the loop is ended, pop the element and append it to the postfixExpression until the 
	stack becomes empty.

	Note: In this particular example, I haven't taken brackets into the considerations. We'll look
	at the another example in which we'll be dealing with brackets too.

	To understand this problem: you may watch this video -> 
	https://www.youtube.com/watch?v=_K6d775lUUY (Part 1 & 2)



*/

import java.util.*;

class S04_InfixToPostfix_1 {

	/* 
		utility function which accepts two characters:
		topOperator -> the top element present on the stack
		currentSymbol -> the current character in the loop

		if the precedence of the topOperator is not higher than the current symbol then
		we return false, otherwise return true.

		^		Power is at the highest priority
		/ % *	These three operators have same priority
		+ -		These two opeartors have same priority
	*/
	public boolean precedenceCheck(char topOperator, char currentSymbol) {

		if(topOperator == '^' && currentSymbol == '^') {
			return false;
			/* 
				this may be a confused statement for you all, I'd suggest, 
				watch this video -> https://www.youtube.com/watch?v=_K6d775lUUY (Part 1 & 2)
			*/
		}
		else if((topOperator == '*' || topOperator == '/' || topOperator == '%') && (currentSymbol == '^')) {
			return false;
		}
		else if((topOperator == '+' || topOperator == '-') && (currentSymbol == '^' || currentSymbol == '%' || currentSymbol == '*' || currentSymbol == '/')) {
			return false;
		}
		else {
			return true;
		}

	}

	/* utility function which checks whether the symbol is operand or operator */
	public boolean isOperator(char currentSymbol) {

		switch(currentSymbol) {
			case '+':
			case '-':
	        case '*':
	        case '/':
	        case '^':
	        case '%':
	        	return true;
		default:
		        return false;
		}

	}

	public String infixToPostfix(String infixExpression) {
		/* building stack & postfixExpression */
		Stack<Character> stack = new Stack<>();
		StringBuilder postfixExpression = new StringBuilder();
		for(int i = 0; i < infixExpression.length(); i++) {
			char currentSymbol = infixExpression.charAt(i);
			/* if currentSymbol is not opearator, append it to the postfixExpression */
			if(!isOperator(currentSymbol)) {
				postfixExpression.append(currentSymbol);
			}
			else {
				/* otherwise, keep checking the precedence until the below condition get failed */
				while (!stack.empty() && precedenceCheck(stack.peek(), currentSymbol)) {
					char poppedOperator = stack.pop();
					postfixExpression.append(poppedOperator);		
				}
				/* and finally push the currentSymbol into the stack */
				stack.push(currentSymbol);
			}
			/* repeat the process */
		}
		/* if some opearators left onto the stack, push them one by one */
		while(!stack.empty()) {
			char poppedOperator = stack.pop();
			postfixExpression.append(poppedOperator);	
		}

		return postfixExpression.toString();
	}

	public static void main(String[] args) {
		S04_InfixToPostfix_1 s = new S04_InfixToPostfix_1();
		String infixExpression = "a*b+c%d-e";
		String postfixExpression = s.infixToPostfix(infixExpression);
		System.out.println(postfixExpression);	
	}

}