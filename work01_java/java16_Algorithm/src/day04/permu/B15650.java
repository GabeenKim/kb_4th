package day04.permu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15650 {
	static int[] ans;
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = new int[M];
		
		dfs(0,1);
	}

	public static void dfs(int n, int s) {
		if(n==M) {
			for(int a : ans) System.out.print(a+" ");
			System.out.println();
			return;
		}
		for(int j =s ;j<=N ;j++) {
			ans[n] = j;
			dfs(n+1,j+1);
		}
	}
}
