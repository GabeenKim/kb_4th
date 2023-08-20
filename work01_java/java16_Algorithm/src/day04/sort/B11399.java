package day04.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int n = 0; n<N; n++)
			arr[n]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		int ans=0, sumNum = 0;
		for(int i=0;i<N;i++) {
			ans += sumNum;
			sumNum +=arr[i];
			ans += arr[i];
		}
		System.out.println(ans);
	}

}
