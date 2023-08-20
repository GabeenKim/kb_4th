package day04.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class J1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i] =  Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<N; i++) {
			int insertIdx = i;
			for(int j=0; j<i;j++) {
				if(arr[i]<arr[j]) { 
					insertIdx = j;
					break;
				}
			}
			int t = arr[i];
			for(int j =i-1 ; j>=insertIdx; j--) {
				arr[j+1] = arr[j];	
			}
			arr[insertIdx] = t;
			for(int n : arr) System.out.print(n+" ");
			System.out.println();
		}
	}

}
