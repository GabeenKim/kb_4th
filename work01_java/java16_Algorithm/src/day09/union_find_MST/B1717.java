package day09.union_find_MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1717 {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		p=new int[N+1];
		//make set
		for (int i=0; i<N+1; i++) p[i]=i;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int check = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(check ==0)union(a,b);
			else {
				if(find(a)==find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}

	}
	public static int find(int n) {
		if(n==p[n]) return n;
		return p[n]=find(p[n]); 
	}
	public static void union(int a, int b) {
		p[find(b)] = find(a);
	}

}
