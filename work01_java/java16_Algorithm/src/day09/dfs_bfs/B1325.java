package day09.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1325 {
	static int N;
	static boolean[] v;
	static ArrayList<Integer> graph[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		
		//연결리스트
		for (int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			graph[e].add(s);
		}
		////
		
		int max = 0;
		int[] ans = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			if(graph[i]!=null) {
				int cntNode = bfs(i);
				if(cntNode>=max) max= cntNode;
				ans[i]=cntNode;
			}
		}
		///출력
		for(int i=1;i<=N;i++) {
			if(ans[i]==max) System.out.print(i+" ");
		}
	}
	
	public static int bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		v = new boolean[N+1];
		int cnt =0;
	
		q.add(s);
		v[s]=true;

		while(!q.isEmpty()) {
			int c = q.poll();		
			cnt++;
			
			for (int j: graph[c]) {	
				if (!v[j]) {
					q.add(j);
					v[j]=true;
				}
			}
		}
		return cnt;
	}
	

}

