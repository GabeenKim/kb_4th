package day04.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2750_insert {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for(int n =0; n<N ;n++) {
			st = new StringTokenizer(br.readLine());
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<N;i++) {
			int insertIdx = i;
			
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[i]) {
					insertIdx = j;
					break;
				}
			}
			//i값 백업
			int t = arr[i];
			//뒤에서부터 한 칸 씩 뒤로 복사
			for(int j = i-1; j>=insertIdx;j--) {
				//i값을 i-1값으로 덮어 씌우기 
				arr[j+1] = arr[j];
			}
			//삽입할 자리에 백업 시켜놓은 i값 삽입
			arr[insertIdx] = t;
		}
		for(int num : arr) {
			System.out.println(num);
		}
	}

}
