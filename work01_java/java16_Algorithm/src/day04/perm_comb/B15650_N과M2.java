package day04.perm_comb;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M2 {
	static int N, M;
	static int[] arr;
	static StringBuilder ans = new StringBuilder();

	public static void main(String[] args) throws IOException {
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		//	입력 처리
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
		//	main함수에서는 가장 상위 dfs만 호출
		//	0번 인덱스에 저장할 숫자를 선택, 시작번호 1
		dfs(0, 1);
		System.out.println(ans);		
	}
	
	public static void dfs(int n, int s) {
		//	[0] 종료조건: 정답처리
		if (n==M) {
			for (int t: arr) ans.append(t).append(" ");
			ans.append("\n");
			return;
		}
		
		//	[1] 하부 호출
		for (int j=s; j<=N; j++) {
			arr[n] = j;		// 선택한 숫자 저장(출력위해서)
			dfs(n+1, j+1);	// 다음숫자 선택하러 하부 호출
		}
	}

}
