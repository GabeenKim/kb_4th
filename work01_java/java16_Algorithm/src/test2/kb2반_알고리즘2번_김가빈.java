package test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kb2반_알고리즘2번_김가빈 {
	static int N,M,date;
	static int[][] arr,v;
	static int[] di= {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		//교육장 크기 열, 행 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M+2][N+2];
		for (int i=1; i<=M; i++) {
			String line = br.readLine();
			for (int j=0; j<N; j++) {
				arr[i][j+1]=line.charAt(j)-'0';
			}
		}
		v= new int[M+2][N+2];
		
		//확진자 학생의 좌표 열, 행 
		st = new StringTokenizer(br.readLine()," "); 
		int sj = Integer.parseInt(st.nextToken());
		int si = Integer.parseInt(st.nextToken());
		
		date = 0;
		//dfs로 마지막 확진자의 확진날짜를 구하고, 퇴소는 +3일 후에 이뤄지므로 정답에는 3을 더해서 출력
		dfs(si,sj,0); //처음 확진자의 좌표와 확진 날짜를 인자로 넣어준다. 
		System.out.println(date+3);
		
		//dfs 이후에도 1이 남아있으면 끝까지 확진이 안 된 사람이다. 따라서 arr배열에서 1인 경우를 센 후 출력
		int cnt =0;
		for(int i=1;i<=N;i++) {
			for(int j=1; j<=M;j++)
				if (arr[i][j] == 1) cnt++;
		}
		System.out.println(cnt);
		
	}
	
	public static void dfs(int ci, int cj, int day) {
		//방문 표시
		v[ci][cj] = 1;
		if(day>date) date= day;
		//추후 arr에서 1인 것의 개수를 세기 위해 현 좌표를 2로 지워준다.
		arr[ci][cj]=2;
		
		//상하좌우를 확인하고 다음 좌표가 미방문이고 참석한 학생이라면 그 학생의 좌표와 감염일 +1한다.
		for (int k=0; k<4; k++) {
			int ni = ci+di[k];
			int nj = cj+dj[k];
			if (v[ni][nj]==0 && arr[ni][nj]==1) {
				dfs(ni,nj,day+1);
				//되돌아가는 경우를 위해 감염일을 -1 해준다. 
				day-=1;
			}
		}
	}
}
