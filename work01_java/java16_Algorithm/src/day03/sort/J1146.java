package day03.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1146 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<N-1 ; i++) {
			int minIdx = i ;
			for(int j = i+1; j<N; j++) {
				if(arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			
			}
			int t = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = t;
			
			for(int n : arr) {
				System.out.print(n+" ");
				}
			System.out.println();
		}

	}

}
