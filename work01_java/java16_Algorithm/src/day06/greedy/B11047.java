package day06.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		int cnt = 0;
		
		for(int n=0; n<N;n++) {
			st = new StringTokenizer(br.readLine());
			arr[n]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=N-1;i>=0;i--) {
			if(arr[i]<=K) {
				cnt += (K/arr[i]);
				K %=arr[i];
			
			}
		}
		System.out.println(cnt);
	}

}
