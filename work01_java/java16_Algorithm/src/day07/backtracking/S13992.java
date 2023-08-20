package day07.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S13992 {
	static int[][] arr;
	static boolean[] v;
	static int N,min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1][N+1];
		
			for(int i=1; i<=N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=1; j<=N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			v= new boolean[N+1];
			min = 100*N;
			dfs(1,0,1); //방문횟수, 비용, 방문도시번호(1부터 시작)
			
			System.out.println("#"+tc+" "+min);
		}
	}
	public static void dfs(int n, int sum,int cur) {
		//n:방문한 횟수
		if(n==N) {
			//복귀비용
			min = Math.min(min,sum+arr[cur][1]);
			return;
		}
		for(int j=2; j<=N;j++) {
			if(v[j]) continue;
			v[j]=true;
			
			dfs(n+1, sum+arr[cur][j],j);
			
			v[j] = false;
		}
	}
}
