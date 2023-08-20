package day08.dfs_bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_dfs_bfs_인접리스트 {
	static int N, M, V;
	static int[][] adjM;
	static ArrayList<Integer> adjL[];
	static boolean[] v;
	static StringBuilder ans;
	public static void main(String[] args) throws IOException {
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
//		// [0] 인접행렬로 그래프 연결 저장
//		adjM = new int[N+1][N+1]; 		 
//		for (int i=0; i<M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int s = Integer.parseInt(st.nextToken());
//			int e = Integer.parseInt(st.nextToken());
//			adjM[s][e] = adjM[e][s] = 1;	//	양방향 연결
//		}
		
		// [0] 인접리스트로 그래프 연결저장
		adjL = new ArrayList[N+1];
		for (int i=0; i<=N; i++) {
			adjL[i] = new ArrayList<>();
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adjL[s].add(e);	//	양방향 그래프
			adjL[e].add(s);
		}
		// 여러노드가 연결된 경우 숫자가 작은 노드부터 탐색
		for (int i=1; i<=N; i++) {
			adjL[i].sort(null);
		}
		
		v = new boolean[N+1];
		ans = new StringBuilder();
		
		// [1] dfs호출
		dfs(V);
		ans.append("\n");
		bfs(V);
		System.out.println(ans);
	}
	
	public static void bfs(int s) {
		// [0] Q, v[], 필요한 플래그 등 생성
		Queue<Integer> q = new LinkedList<>();
		v = new boolean[N+1];
		
		// [1] Q에 초기데이터(들!) 삽입, v[]표시, 필요시 정답처리!
		q.add(s);
		v[s]=true;
		ans.append(s).append(" ");
		
		// [2] Q에 데이터 있는 동안 반복처리!
		while(!q.isEmpty()) {
			int c = q.poll();		//	큐에서 데이터 한개 꺼냄
									//	정답처리는 가능한 이자리에서..
			for (int j: adjL[c]) {	// 연결된 노드, 조건에 맞으면 큐에 삽입
				if (!v[j]) {
					q.add(j);
					v[j]=true;
					ans.append(j).append(" ");
				}
			}
		}
	}
	
	
	public static void dfs(int n) {
		// [0] 방문표시, 처음방문시 해야할 일 있으면 여기서..!
		v[n] = true;
		ans.append(n).append(" ");
		
		// [1] 4/8방향, 연결된 노드들 등.. 반복처리
//		// 인접행렬을 사용한 방법
//		for (int j=1; j<=N; j++) {	//	1 ~ N 노드에 대해 연결 체크!
//			if (adjM[n][j]==1 && !v[j]) {
//				dfs(j);
//			}
//		}
		
		// 인접리스트 사용
		for (int j: adjL[n]) {
			if (!v[j]) dfs(j);
		}
	}

}
