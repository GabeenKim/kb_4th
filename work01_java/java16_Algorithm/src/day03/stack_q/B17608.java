package day03.stack_q;

import java.util.Scanner;
import java.util.Stack;

public class B17608 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack  = new Stack<>();
		
		int N = sc.nextInt();
		for(int i =0 ; i<N;i++) {
			int n =sc.nextInt();

			while(!stack.isEmpty()&& stack.peek() <= n ) {
				stack.pop();
			}
			stack.push(n);
		}
	System.out.println(stack.size());
}
//		int top = stack.pop();
//		int cnt = 1;
//		int nextTop = 0;
		
//		while(!stack.isEmpty()) {
//			nextTop = stack.pop();
//			if ( top < nextTop ) {
//				cnt ++;
//				top = nextTop;
//			}	
//		}
////		System.out.println(stack.size());
//	}

}
