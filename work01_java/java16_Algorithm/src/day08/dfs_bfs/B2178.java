package day08.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	public int i;
	public int j;
	
	Pos(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class B2178 {
	static int[][] arr;
	static int[][] v;
	static int N,M;
	static int[] di= {-1,1,0,0},dj= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//범위체크 X하기 위해 
		arr = new int[N+2][M+2];
		
		for(int i=1; i<=N;i++) {
			String line = br.readLine();
			for(int j=0; j<M;j++) {
				arr[i][j+1]=line.charAt(j)-'0';
			}
		}
		
		int ans = bfs(new Pos(1,1));
		System.out.println(ans);
	}
	
	public static int bfs(Pos s) {
		Queue<Pos> q= new LinkedList<>();
		v = new int[N+2][M+2];
		
		q.add(s);
		v[s.i][s.j]=1;
		
		while(!q.isEmpty()) {
			//큐에서 데이터 하나 꺼내고 종료관련 처리는 꺼낸 것을 기준으로
			Pos c = q.poll();
			if(c.i ==N &&c.j==M) return v[c.i][c.j];
			
			for(int k=0;k<4;k++) {
				int ni = c.i+di[k];
				int nj = c.j+dj[k];
				//1.범위 내(현재는 스킵) 2.미방문 3.조건(현재는 1이면)
				if(v[ni][nj]==0 && arr[ni][nj]==1) {
					q.add(new Pos(ni,nj));
					v[ni][nj]=v[c.i][c.j]+1;
				}
		
			}//for문
		}//while
		//목적지를 찾지 못한 경우
		return -1;
	}
}
	

