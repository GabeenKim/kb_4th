package test;
//함수로 생성해서 탈출하는게 좀 더 쉬움
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kb2반_알고리즘3번_김가빈 {
	static int[] di= {-1,1,0,0,-1,-1,1,1};
	static int[] dj= {0,0,-1,1,-1,1,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//	파일로부터 읽기
		StringTokenizer st;

		//범위체크 안 하려면 사이즈 21/21
		int[][] arr = new int[19][19];
		int[] cnt = new int[2];
		
		int ansi=0,ansj=0;
		
		//arr배열에 입력 값 저장(2차원)
		for (int i=0; i<19; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//배열 순회 
		for(int si=0;si<19;si++) {
			for(int sj=0;sj<19;sj++) {
				if(arr[si][sj]==0)continue;
				cnt[0]=1; cnt[1]=1;
				//8방향(상하좌우, 대각선 4개)
				for(int k =0;k<8;k++) {
					//현재 위치로부터 4칸 떨어진 곳까지 탐색하며 다음 좌표 변경
					for(int m=1; m<=4; m++) {
						//범위를 벗어나면 다음 과정은 건너 뛴다.
						if(0<si +di[k]*m && si +di[k]*m>=19
								&& 0<sj +dj[k]*m && sj +dj[k]*m>=19) continue;
						//범위 내이면 다음 좌표를 지정해 준다.
						int ni = si +di[k]*m;
						int nj = sj +dj[k]*m;
						
						//다음 값이 1인 경우 각 색의 돌 개수를 +1한다
						if(arr[ni][nj] == 1) cnt[0]+=1;
						else if(arr[ni][nj] == 2) cnt[1]+=1;
						
						//돌의 개수가 5가 되면 승리이므로 남은 방향 확인 X 탈출
						if(cnt[0]== 5)break;
						if(cnt[1]== 5)break;
					}
				}//방향확인 loop
				//System.out.println(cnt[0]+" "+cnt[1]);
				
//				if(cnt[0]== 5)break;
//				if(cnt[1]== 5)break;
			}
		}//순회 loop
		
		if(cnt[0]==5) System.out.println(1);
		else if(cnt[1]==5) System.out.println(2);
		else System.out.println(0);
	}
}
