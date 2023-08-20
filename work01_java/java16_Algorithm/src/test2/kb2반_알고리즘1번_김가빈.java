package test2;

//N<=100이므로 유니온-파인드로 푼다. 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kb2반_알고리즘1번_김가빈 {
	static int[] p;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		//각자 자기가 부모인 부모테이블 초기화
		p = new int[N+1];
		for(int n=1;n<=N;n++) p[n] = n;
		
		//각 친구들이 관계를 맺으면 같은 그룹으로 묶기 위함. 
		//입력 받은 관계에 대해 union() 
		for(int i=0; i<E;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a,b);
		}
		//철수와 친구인 사람들은 같은 그룹이므로 부모테이블의 값이 철수와 같다. 
		//따라서 1번인 철수와 같은 그룹인 사람들은 부모테이블의 값이 1이다.
		int cnt = 0;
		for(int n=1;n<=N;n++) {
			if(p[n]==1) cnt++;
		}
		//철수를 제외한 나머지 친구들의 수를 구해야 하므로 -1을 해준다.
		System.out.println(cnt-1);
	}
	//만약 자기 자신이 부모가 아니라면 내 부모의 부모를 찾아서 값을 변경함. 
	public static int findSet(int n) {
		if (n==p[n]) return n;
		return p[n]= findSet(p[n]);
	}
	//같은 그룹으로 묶어주기 위해 b의 부모를 a의 부모로 변경한다. 
	public static void union(int a, int b) {
		p[findSet(b)] = findSet(a); 
	}
}
