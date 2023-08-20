package test;
//for문 3개 i,j,k이용해서도 가능 

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kb2반_알고리즘2번_김가빈 {
	static int N,M;
	static int[] arr;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) arr[i]=Integer.parseInt(st.nextToken());
		
		max=0;
		
		dfs(0,0,0);
		System.out.println(max);

	}
	public static void dfs(int n, int cnt, int sum) {
		//n: 뽑을 것의 인덱스 
		//종료조건
		if(n==N) {
			//3개를 뽑았을 때 그 때의 합이 M을 넘지 말아야 하며
			if(cnt==3 && sum <= M) {
				//또 합이 최댓값이어야 정답임.
				if(sum >max) max= sum;
			}
			return;
		}
		//선택 O은 경우 현재 n번째 인덱스의 값을 합해줌. 
		dfs(n+1,cnt+1, sum+arr[n]);
		//선택 X
		dfs(n+1, cnt, sum);
	}

}
