package day03.stack_q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		Stack<Integer> stk = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		StringBuilder sb = new StringBuilder();
		
		//	N개의 숫자를 입력받아서 스택에서 꺼낸숫자와 비교
		for (int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			//	스택 제일 위 값이 n인지 체크
			while (cnt <= N+1) {
				if (!stk.isEmpty() && stk.peek()==n) {
					sb.append("-\n");
					stk.pop();
					break;
				}else {
					stk.push(cnt++);
					sb.append("+\n");
				}
			}
			if (cnt>N+1)	break;
		}
		if (cnt>N+1) {	//	답을 못찾은 경우
			System.out.println("NO");
		}else {
			System.out.println(sb);
		}
	}

}
