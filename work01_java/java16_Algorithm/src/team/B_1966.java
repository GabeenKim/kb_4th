package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		int TC = Integer.parseInt(st.nextToken());

		for(int tc=0; tc<TC; tc++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			LinkedList<Integer> arrIdx = new LinkedList<>();

			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0;i<N;i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
				arrIdx.add(i);
			}
			//1개일 때 처리
			if (N==1) {
				queue.poll();
				System.out.println(1);
				continue;
			}

			int cnt = 0;
			while(!queue.isEmpty()) {
				//max값 찾기
				int max = Collections.max(queue);
				int maxIdx = ((LinkedList<Integer>)queue).indexOf(max);

				//maxidx만큼 삭제 삽입 반복
				for(int i=0;i<maxIdx;i++) {
					int num = queue.poll();
					int numIdx = arrIdx.removeFirst();
					queue.offer(num);
					arrIdx.add(numIdx);
				}
				queue.poll();
				int temp = arrIdx.removeFirst();
				if(temp==M) {
					cnt++;
					break;
				}
				else cnt++;

			}
			System.out.println(cnt);
		}


	}
}