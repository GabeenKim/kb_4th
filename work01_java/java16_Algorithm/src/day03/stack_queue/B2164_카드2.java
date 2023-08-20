package day03.stack_queue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.management.Query;

public class B2164_카드2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		
		//	[0] 1 ~ N을 큐에 순서대로 넣기
		for (int i=1; i<=N; i++)	queue.add(i);
		
		//	[1] 큐크기 1초과인 동안, 1개 버리고, 1개 제일뒤로
		while (queue.size()>1) {
			queue.poll();			//	1개 꺼내서 버림
			queue.add(queue.poll());//	1개 꺼내서 제일 뒤에 붙임
		}
		System.out.println(queue.poll());
	
	}

}
