package day04.permu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961 {
	static int[][] arr;
	static int N;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		//S,B
		arr = new int[N][2];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		min=1000000000;
		dfs(0,1,0);
		System.out.println(min);
	}
	public static void dfs(int n, int s, int b) {
		if(n==N) {
			if(b>0 && Math.abs(s-b)<min) {
				min = Math.abs(s-b);
			}
			return;
		}
		dfs(n+1,s*arr[n][0],b+arr[n][1]);
		dfs(n+1,s,b);
	}
}
