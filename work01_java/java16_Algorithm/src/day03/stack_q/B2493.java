package day03.stack_q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 {

	public static void main(String[] args) throws IOException {
		//높이와 인덱스를 같이 저장해주기 위해 
		Stack<Integer[]> stack = new Stack<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		
		for(int cnt =1 ; cnt <=N; cnt++) {
			//높이를 입력 받
			int n =Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && n > stack.peek()[0]) {
				stack.pop();
			}
			if(stack.isEmpty()) sb.append("0 ");
			else sb.append(stack.peek()[1]+" ");
			
			//스택에 자신의 높이와 인덱스를 배열 형식으로 삽입 
			stack.push(new Integer[] {n, cnt});
		}
		System.out.println(sb);
		
	}

}
