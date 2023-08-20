package day07.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B9663 {
	static int N,ans;
	static boolean[] v1,v2,v3;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//	[0] 입력처리
		N = Integer.parseInt(st.nextToken());
	
		//v2, v3는 대각선 체크 -> 따라서 N*2
		v1 = new boolean[N];
		v2 = new boolean[N*2];
		v3 = new boolean[N*2];
		ans = 0;
		
		dfs(0);
		System.out.println(ans);
	}
	public static void dfs(int n) {
		if(n==N) {
			ans++;
			return;
		}
		for(int j=0; j<N;j++) {
			if(!v1[j] && !v2[n+j] && !v3[n-j+N]) {
				v1[j]=v2[n+j]=v3[n-j+N] = true;		
				dfs(n+1);
				v1[j]=v2[n+j]=v3[n-j+N] = false;
			}
		}
	}
	
}
