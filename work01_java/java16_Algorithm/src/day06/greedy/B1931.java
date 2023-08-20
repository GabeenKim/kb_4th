package day06.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2]; // s, e
				
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[n][0] = Integer.parseInt(st.nextToken());//s
			arr[n][1] = Integer.parseInt(st.nextToken());//e
		}
		
		//종료 시간 기준으로 오름차순 정렬 
		//종료 시간이 같으면 시작시간을 오름차순 정렬 
		//-> ex) 6,6 / 4,6 일때 6,6이 먼저나오면 4,6이 할당이 안됨...!
//		Arrays.sort(arr, (a1,a2)->{
//			if(a1[1]==a2[1]) return a1[0]-a2[0];
//			return a1[1]-a2[1];
//		});
		Arrays.sort(arr,(x,y)->x[1]==y[1]?x[0]-y[0]:x[1]-y[1]);
		
		int cnt = 1;
		int end = arr[0][1];
		for(int i=1;i<N;i++) {
			if(arr[i][0]>= end) {
				cnt+=1;
				end = arr[i][1];
			}
		}
		System.out.println(cnt);
	}

}
