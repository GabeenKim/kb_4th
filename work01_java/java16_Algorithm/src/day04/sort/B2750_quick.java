package day04.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2750_quick {
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for(int n =0; n<N ;n++) {
			st = new StringTokenizer(br.readLine());
			arr[n] = Integer.parseInt(st.nextToken());
		}
		quickSort(0,N-1);
		
		StringBuilder sb = new StringBuilder();
		for(int num : arr) sb.append(num).append("\n");
		System.out.println(sb);
	}
	
	public static void quickSort(int s, int e) {
		if(s>=e) return ;
		
		int p = partition(s,e);
	
		quickSort(s, p-1);
		quickSort(p+1, e);
	}
	
	public static int partition(int s, int e) {
		int p = s++;
		while(s<e) {
			while(s<e && arr[p]>arr[s]) s++;
			while(s<e && arr[p]<arr[e]) e--;
			
			if(s<e) {
				int t = arr[s];
				arr[s] = arr[e];
				arr[e] = t; 
			}
		}
		if(arr[p]<=arr[s]) s--;
		int t = arr[p];
		arr[p] = arr[s];
		arr[s]=t;
		
		return s;
	}
	

}
