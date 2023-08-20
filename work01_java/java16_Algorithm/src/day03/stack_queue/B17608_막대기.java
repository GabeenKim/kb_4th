package day03.stack_queue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17608_막대기 {

	public static void main(String[] args) throws IOException {
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
//		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			//	N개의 숫자 입력을 받음
			int n = Integer.parseInt(br.readLine());
			
			//	스택은 pop, peek 사용시 반드시 empty체크
			//	지금들어온 숫자가 크거나 같은경우(이전숫자 필요없음)
			while (!stack.isEmpty() && stack.peek() <= n) {
				stack.pop();
			}
			stack.push(n);
		}
		System.out.println(stack.size());
	}

}
