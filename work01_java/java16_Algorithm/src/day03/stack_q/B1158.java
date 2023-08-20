package day03.stack_q;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for(int i =1;i <=N; i++) {
			queue.offer(i);
		}
		
		while(queue.size()>0) {
			for(int j = 0; j<K-1;j++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll()+", ");
		}
		sb.delete(sb.length()-2,sb.length());
		sb.append(">");
		System.out.println(sb);
	}

}
