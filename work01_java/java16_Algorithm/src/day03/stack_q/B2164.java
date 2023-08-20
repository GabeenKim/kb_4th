package day03.stack_q;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2164 {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=1 ; i<=N; i++) 
			queue.offer(i);
		
		//큐의 크기가 1초과인 동안,  1개 버리고 1개 삽입
		while(queue.size()>1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		System.out.println(queue.peek());
	}
}
