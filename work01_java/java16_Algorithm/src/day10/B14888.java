package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888 {
	static int N,max,min;
	static int[] arr, op;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		op = new int[4];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int n=0;n<N;n++) arr[n] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for(int n=0;n<4;n++) op[n] = Integer.parseInt(st.nextToken());
		
		max = -10000000;
		min = 100000000;
		
		dfs(1,arr[0],op[0],op[1],op[2],op[3]);
		
		
		System.out.println(max);
		System.out.println(min);
	}
	public static void dfs(int n, int result,int add,int sub,int mul,int div) {
		if(n==N) {
			max = Math.max(max,result);
			min = Math.min(min,result);
			return;
		}
		if(add>0) dfs(n+1, result+arr[n],add-1, sub,mul,div);
		if(sub>0) dfs(n+1, result-arr[n],add, sub-1,mul,div);
		if(mul>0) dfs(n+1, result*arr[n],add, sub,mul-1,div);
		if(div>0) {
			if(result<0) dfs(n+1, (result*(-1)/arr[n])*(-1),add, sub,mul,div-1);
			else dfs(n+1, result/arr[n],add, sub,mul,div-1);
		}	
	}
}
