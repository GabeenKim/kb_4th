package day01.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1210_ladder1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = 10;
		int[][] arr = new int[100][102];
		for (int tc=1; tc<=TC; tc++) {
			//	[0] 입력처리 (100*100)
			int t = Integer.parseInt(br.readLine()); //	사용하지 않음
			for (int i=0; i<100; i++) {
				//	100행 데이터를 읽음
				st = new StringTokenizer(br.readLine(), " ");
				for (int j=1; j<=100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			//	[1] 목적지 == 2, j 좌표 찾기
			int ci=99, cj=1;
			for (cj=1; cj<=100; cj++) {
				if (arr[ci][cj]==2) break;
			}
			
			//	[2] 좌우우선, 없으면 위로 (지나온길 0으로)
			while (ci>0) {
				arr[ci][cj]=0;	//	길 지우기
				if (arr[ci][cj-1]==1)		cj--;
				else if (arr[ci][cj+1]==1)	cj++;
				else 						ci--;
			}
			System.out.println("#"+tc+" "+(cj-1)+"\n");
		}

	}

}
