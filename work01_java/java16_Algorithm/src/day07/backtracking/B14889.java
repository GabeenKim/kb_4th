package day07.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14889 {
	static int[][] arr;
	static int[] alist, blist;
	static int N,min,cntA,cntB;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		alist = new int[N];
		blist = new int[N];
		
		for(int i =0; i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j =0; j<N;j++) {
				arr[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		cntA=cntB=0;
		min = 100*N;
		
		dfs(0,0,0);
		
		System.out.println(min);
	}
	public static void dfs(int n, int cntA, int cntB) {
		//가지치기
		//if(cntA>N/2 || cntB>N/2) return;//->시간은 더 늘어남.
		
		//두 팀의 인원수가 동일할 때 차이의 최솟값 갱신.
		if(n==N) {
			if(cntA==cntB) {
				int aSum=0, bSum=0;
				for(int i=0;i<cntA-1;i++) {
					for(int j=i+1;j<cntB;j++) {
						aSum += arr[alist[i]][alist[j]] + arr[alist[j]][alist[i]];
						bSum += arr[blist[i]][blist[j]] + arr[blist[j]][blist[i]];
					}
				}
//				for(int i=0; i<cntA;i++) {
//					for(int j=0; j<cntA;j++) {
//						aSum += arr[alist[i]][alist[j]];
//						bSum += arr[blist[i]][blist[j]];
//					}
//				}
				min = Math.min(min, Math.abs(aSum-bSum));
			}
			return;
		}
		//a팀으로 선택
		alist[cntA]=n;
		dfs(n+1,cntA+1,cntB);
		//b팀으로 선택
		blist[cntB]=n;
		dfs(n+1,cntA,cntB+1);
	}

}
