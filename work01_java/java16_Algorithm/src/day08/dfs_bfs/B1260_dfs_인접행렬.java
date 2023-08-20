package day08.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1260_dfs_인접행렬 {
	static int N,M,V;
	static int[][] adjM;
	static boolean v[];
	static StringBuilder ans;
	//static LinkedList<Integer> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		//인접행렬
		adjM= new int[N+1][N+1];
		
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adjM[start][end]= adjM[end][start]=1; //양방향
					
		}
		v= new boolean[N+1];
		ans = new StringBuilder();
		
		dfs(V);
		
		System.out.println(ans);
	}
	public static void dfs(int n) {
		//중복 방지를 위해 방문 표시, 처음 방문 시 해야할 일이 있으면 여기에 작성
		v[n] = true;
		ans.append(n).append(" ");
		
		//4/8방향, 연결노드 등 반복처리
		//1번부터 N번노드까지 현재 n과 연결되어 있는지 확인하고, 연결되어 있을 시 그곳이 next
		for(int j=1;j<=N;j++) {
			if(adjM[n][j]==1 && !v[j]) {
				dfs(j);
			}
		}		
	}
}
