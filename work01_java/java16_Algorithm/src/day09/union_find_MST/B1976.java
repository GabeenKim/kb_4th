package day09.union_find_MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1976 {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		p=new int[N+1];
		for(int i=1;i<=N;i++) p[i] = i;
		
		int[][] arr = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			st= new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		int[] plan = new int[N+1];
		st= new StringTokenizer(br.readLine()," ");
		
		for(int i=1;i<=N;i++) plan[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(arr[i][j]==1) {
					union(i,j); //같은 집합으
					arr[j][i] = 0;
				}
			}
		}
		
		int j=0,cnt =0;
		for(int i=1;i<=N-1;i++) {
			j = i+1;
			
			if(find(plan[i])!=find(plan[j])) {
				System.out.println("NO");
				break;
			}
			else cnt+=1;
		}
		if(cnt==plan.length-2)System.out.println("YES");
		System.out.println(Arrays.toString(p));
	}
	
	public static int find(int n ) {
		if(n==p[n]) return n;
		return p[n]= find(p[n]);
	}
	
	public static void union(int a, int b) {
		p[find(b)]=p[find(a)];
	}

}
