package test2;

//M<=10 이고 밀기, 던지기로 선택지가 2가지 뿐이니 백트래킹으로 푼다. 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kb2반_알고리즘3번_김가빈 {
	static int N,M, max;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//직선구간 입력 받기
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=N;i++) arr[i]= Integer.parseInt(st.nextToken());
		
		//최댓값을 찾기 위해 최악의 값 설정
		max = 0;
		//초기 횟수, 인덱스, 크기
		dfs(0,0,1);
		System.out.println(max);
	}
	
	public static void dfs(int n, int idx, int sum) {
		//던지는 횟수가 끝났거나 덩어리가 끝 지점에 도달한 경우 종료한다. 
		if(n==M || idx ==N) {
			//이 때의 크기가 최댓값인 경우가 정답이다. 
			if(sum>max) max = sum;
			return;
		}
		
		//밀기를 선택한 경우 현재 위치에서 +1만큼 떨어진 곳의 크기를 더함
		dfs(n+1, idx+1, sum+arr[idx+1]);
		//던지기를 선택한 경우 현재까지의 크기에서 절반이 줄어들고 그 크기에 +2만큼 떨어진 곳의 크기를 더함. 
		dfs(n+1, idx+2, sum/2+arr[idx+2]);
	}
}
