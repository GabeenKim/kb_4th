package day09.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1325_2 {
	static int N;
	static int[] ans;
	static boolean[] v;
	static ArrayList<Integer> graph[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		///입력 저장
		for (int i=0; i<=N; i++) graph[i] = new ArrayList<>();
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s].add(e);
		}
		///
//		System.out.println(Arrays.deepToString(graph));
		ans = new int[N+1];
		
		for(int i=1;i<=N;i++) 	bfs(i);
		
//		System.out.println(Arrays.toString(ans));
		int max = 0;
		for(int m : ans) if(m>max)max=m;
		///출력
		for(int i=1;i<=N;i++) {
			if(ans[i]==max) System.out.print(i+" ");
		}
	}
	
	public static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		v = new boolean[N+1];
	
		q.add(s);
		v[s]=true;

		while(!q.isEmpty()) {
			int c = q.poll();		
			
			for (int j: graph[c]) {	
				if (!v[j]) {
					q.add(j);
					v[j]=true;
					ans[j]++;
				}
			}
		}
	}
	
}

