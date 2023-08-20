package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11724 {
	static int[] p; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		p = new int[N+1];
		for(int i=1; i<=N;i++) p[i] = i;
		
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			union(u,v);
		}

		int cnt = 0;
		for(int i=1; i<=N;i++)
			if(p[i]==i) cnt++;
		System.out.println(cnt);
	}
	
	public static int findSet(int n) {
		if (n==p[n]) return n;
		return p[n]= findSet(p[n]);
	}
	public static void union(int a, int b) {
		p[findSet(b)] = findSet(a); 
	}
}
