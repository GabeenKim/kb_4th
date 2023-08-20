package day06.tree;

import java.util.Arrays;

public class PostOrder {
	static char[] arr;
	static int N=10;
	public static void main(String[] args) {
		arr= new char[N+1];
		for(int n=1; n<=N;n++) {
			arr[n]=(char)('A'+n-1);
		}
		System.out.println(Arrays.toString(arr));
		postOrder(1);
	}
	
	//전위순회
	public static void postOrder(int n) {
		//종료조건 : 1~N까지 존재하는 노드
		if(1<=n && n<= N) {
			//좌측 탐색
			postOrder(n*2);//왼
			//우측 탐색
			postOrder(n*2+1);//오
			//중앙 :노드, 저장된 값을 출력
			System.out.print(arr[n]+" ");
			
			
			
		}
	}

}
