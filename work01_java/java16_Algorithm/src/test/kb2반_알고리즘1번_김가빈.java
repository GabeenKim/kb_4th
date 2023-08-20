package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kb2반_알고리즘1번_김가빈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		//배열에 입력 값 저장 
		int[] arr= new int[N];
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		//i인덱스 위치에 i~N-1인덱스를 조회하면서 최대값을 찾아내고 최대값을 갖는 인덱스와 i인덱스의 값을 교환한
		//i : 원소 삽입할 위치
		for(int i=0;i<N;i++) {
			int max = 0;
			int idx=i;
			//j : max 값 찾을 인덱스
			for(int j=i;j<N;j++) {
				//최대값 찾기 
				if (arr[j]>max) {
					max =arr[j];
					//최댓값의 인덱스
					idx = j;
				}
			}
			//최댓값을 갖는 인덱스를 i에 삽입하고 i에 있던 값은 idx인덱스에 삽입 
			int t = arr[i];
			arr[i]=arr[idx];	
			arr[idx]=t;
		}
		for(int num : arr) System.out.println(num);
	}
	

}
