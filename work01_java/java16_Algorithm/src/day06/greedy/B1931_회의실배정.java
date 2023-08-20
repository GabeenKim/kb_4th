package day06.greedy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931_회의실배정 {

	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// [0] 입력처리
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2]; 
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// [1] 종료시간기준 오름차순, 같으면 시작시간 오름차순 정렬
		Arrays.sort(arr, (x,y)->x[1]==y[1]?(x[0]-y[0]):x[1]-y[1]);

		int ans=0, last=0;
		for (int i=0; i<N; i++) {
			if (last<=arr[i][0]) {	//	마지막종료시간<=시작시간 => 할당 가능한 회의
				ans++;				//	회의수 ++
				last = arr[i][1];	//	마지막회의시간 갱신
				
			}
		}
		System.out.println(ans);
	}
}
