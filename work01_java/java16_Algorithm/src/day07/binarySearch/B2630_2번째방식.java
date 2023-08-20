package day07.binarySearch;
//1) 색이 같은지 여부를 함수로 생성해서 안 같으면 탈출하게 생성 -> 색 판단 시 하나라도 다르면 return 
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2630_2번째방식 {
	static int[][] arr;
	static int bCnt, wCnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N =Integer.parseInt(br.readLine());
		 arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		wCnt = bCnt = 0;
		//[1] 주어진 범위에서 흰/파란색 종이 개수를 증가 
		countColor(0,0,N);
		System.out.println(wCnt);
		System.out.println(bCnt);
	}
	
	public static void countColor(int si, int sj, int N) {
		//[0] 종료조건 : N<1
		if(N<1)return;
		
		//[1] 흰색과 파란색 개수 카운팅
		int[] cnts= {0,0};
		//si~si+N이 색종이의 한 변의 범위
		for(int i=si;i<si+N;i++) {
			for(int j=sj;j<sj+N;j++) {
				cnts[arr[i][j]]++;
			}
		}
		
		//[2]모두 같으면 각 색의 종이 카운트, 아닌 경우는 4등분
		if(cnts[0]==N*N) wCnt++;
		else if(cnts[1]==N*N) bCnt++;
		else {
			int m = N/2;
			countColor(si,sj,m);
			countColor(si,sj+m,m);
			countColor(si+m,sj,m);
			countColor(si+m,sj+m,m);
		}
	}

}
