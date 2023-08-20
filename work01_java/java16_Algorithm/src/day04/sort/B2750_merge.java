package day04.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2750_merge {
	static int[] arr; 
	static int[] tArr; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		tArr = new int[N];
		
		for(int n =0; n<N ;n++) {
			st = new StringTokenizer(br.readLine());
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(0,N-1);
		
		StringBuilder sb = new StringBuilder();
		for(int num : arr) sb.append(num).append("\n");
		System.out.println(sb);
	}
	
	public static void mergeSort(int left, int right) {
		if(left>=right) return ;
		
		int m = (left+right)/2;
		mergeSort(left, m);
		mergeSort(m+1, right);
		
		for(int i=left; i<=right;i++) tArr[i] =arr[i];
		
		int l = left;
		int r = m+1;
		int i = left;
		while(l<=m && r<= right) {
			if(tArr[l]<tArr[r]) arr[i++] = tArr[l++];
			else arr[i++] = tArr[r++];
		}
		while(l<=m)arr[i++] = tArr[l++];
		while(r<=m)arr[i++] = tArr[r++];
		
	}
}
