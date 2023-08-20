package day07.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		
		st = new StringTokenizer(br.readLine()," ");
		for(int n=0; n<N;n++) arr[n]= Integer.parseInt(st.nextToken());
	
		int M = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine()," ");
		for(int n=0; n<M;n++) {
			int target  = Integer.parseInt(st.nextToken());
			int start=0, end=N-1;
			while(start<=end) {
				int m = (start+end)/2;
				if(arr[m]==target) {
					System.out.println(1);
					break;
				}
				if(arr[m]>target) end = m-1;
				if(arr[m]<target) start =m+1;
			}
			if(start>end)System.out.println(0);
		}
		
	}

}
