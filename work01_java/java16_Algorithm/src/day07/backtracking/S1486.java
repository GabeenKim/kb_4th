package day07.backtracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1486 {
	static int B, N;
	static int[] arr;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			//	입력 처리
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
	
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i=0; i<N; i++) arr[i]=Integer.parseInt(st.nextToken());
			
			min = 10000*N;
			//	main함수에서는 가장 상위 dfs만 호출
			dfs(0, 0);
			
			System.out.println("#"+t+" "+min);
		}
	}
	
	public static void dfs(int n, int sum) {
		//가지치기 : 이미 정답보다 큰 경우 -> 비교횟수는 줄었으나 비교식에 연산이 있어서 시간은 줄지 않음.
		//if(sum-B>min) return;
		//	[0] 종료조건: 정답처리
		if (n==N) {
			//	하나이상의 숫자선택, 합-B의 최솟값이 정답
			if (sum>=B){
				if(sum-B<min) min = sum-B;
			}
			return;
		}
		
		//	[1] 하부 호출
		dfs(n+1,sum+arr[n]);	// 선택하는 경우
		dfs(n+1,sum);				// 선택하지 않는 경우
	}

}
