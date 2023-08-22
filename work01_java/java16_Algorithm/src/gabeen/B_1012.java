package gabeen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1012 {
	static int N,M,ans,cnt;
	static int[][] arr;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine()," ");
			
			M =  Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			arr = new int[N+2][M+2];
			
			int K = Integer.parseInt(st.nextToken());
			
			for(int k=0; k<K;k++) {
				st = new StringTokenizer(br.readLine()," ");
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				arr[row][col] = 1;
			}//입력 

			ans = N*M;
			cnt = 0;
			dfs(1,1);
			System.out.println(ans);
		}//tc
	}
	public static void dfs(int row, int col) {
		if(row==N+1) {
			ans = Math.min(cnt, ans);
			return;
		}
		for(int j=1;j<=M;j++) {
			if(arr[row][j]==0) continue;
			cnt++;
			arr[row][j] =0;
			for(int k=0;k<4;k++) {
				int ni = row + di[k];
				int nj = j + dj[k];
				if(arr[ni][nj] == 1)
					dfs(ni,nj);
			}
			arr[row][j] =1;
		}
	}

}
