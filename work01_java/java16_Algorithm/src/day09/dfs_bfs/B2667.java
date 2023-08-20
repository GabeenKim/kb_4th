package day09.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2667 {
	static int[] di= {-1,1,0,0},dj= {0,0,-1,1};
	static int[][] arr;
	static boolean[][] v;
	static int N,cnt,cntNum;
	static int[] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		
		//범위체크 X하기 위해 
		arr = new int[N+2][N+2];
		
		for(int i=1; i<=N;i++) {
			String line = br.readLine();
			for(int j=0; j<N;j++) {
				arr[i][j+1]=line.charAt(j)-'0';
			}
		}
		cnt = 0 ;
		v = new boolean[N+2][N+2];
		ans = new int[N*N];
		int idx =0;
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				cntNum =0;
				if(arr[i][j]==1) 
					if(dfs(i,j)) cnt++;
				if(cntNum!=0)
				ans[idx]=cntNum;
				idx++;
			}
		}
		//지문 잘 읽기! 답안 정렬 후 제출임.
        Arrays.sort(ans);
        
		System.out.println(cnt);
		for(int n: ans) {
			if(n!=0) System.out.println(n);
		}
	}
	public static boolean dfs(int i, int j) {
		if(v[i][j]) return false;
		v[i][j]= true;
		arr[i][j]= 0;
		
		cntNum++;
		
		for (int k=0; k<4; k++) {
			int ni = i+di[k];
			int nj = j+dj[k];
			
			if(!v[ni][nj] && arr[ni][nj]==1) {
				dfs(ni,nj);
			}
		}
		return true;
	}

}
