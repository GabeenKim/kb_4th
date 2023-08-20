package day07.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5209 {
	static int[][]arr;
	static boolean[] visited;
	static int N,min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int i=0; i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[N];
			//정확히 계산할 수 있으면 해주는 것이 좋음! 
			min = 99*N;
			
			dfs(0,0);
			
			System.out.println("#"+tc+" "+min);
		}
	}
	public static void dfs(int n,int sum) {
		//가지치기 : 작성 위치는 함수 최상단, 작성 순서는 가장 마지막
		if (min<=sum) return; // 이미 현재까지의 최솟값과 동일하거나 크면, 정답 갱신되지 않도록 리턴!
		//종료 조건
		if(n==N) {
			//정답 처리
			if (sum<min) min = sum;
			return;
		}
		//하부함수 호출
		for(int j=0; j<N;j++) {
			//이미 사용한 열이면 다음 열로 넘어감.
			if(visited[j])continue;
			visited[j]=true;
			
			dfs(n+1,sum+arr[n][j]);
			visited[j]=false;
			
		}
		
	}
}
