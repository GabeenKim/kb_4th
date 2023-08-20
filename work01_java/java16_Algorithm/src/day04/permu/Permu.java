package day04.permu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Permu {
	static int[] ans;
	static boolean[] v;
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = new int[M];
		//숫자(1~N까지 선택 여부 확인하기 위해 size N+1)
		v = new boolean[N+1];
		
		//n은 선택한 숫자 개수
		//main에서 가장 상위 dfs만 호출
		dfs(0);
	}

	public static void dfs(int n) {
		//[1]종료조건
		if(n==M) {
			//정답처리
			for(int a: ans) System.out.print(a+" ");
			System.out.println();
			return;
		}
		//[2]하부 함수 호출(1~N 까지)
		for(int i=1;i<=N;i++) {
			//중복 체크 
			if(v[i]) continue;
			//숫자를 선택하는 상황(v,arr표시)
			v[i]= true;
			ans[n]=i;
					
			dfs(n+1);
			
			//중복 해제 -> 원래대로
			v[i] = false;
		}
	}
	
}
