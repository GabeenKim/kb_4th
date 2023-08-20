package com.edu.hw;

import java.util.Arrays;
import java.util.Scanner;

public class FlattenBoxTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		int boxLen = 100;
		
		for(int tcn = 1; tcn<=tc; tcn++) {
			int dump = sc.nextInt();
			int[ ] boxes = new int[boxLen];
			for(int i=0; i<boxes.length; i++) {
				boxes[i] = sc.nextInt();
			}//초기화
			
			int heighDiff=flatten(boxes,dump );
			System.out.printf("#%d %d%n",tcn, heighDiff);
		}

	}

	static int flatten(int[] boxes, int dump) {
		//코드구현
		int maxNum = 0;
		int minNum = 1000;
		
		int maxIdx = 0;
		int minIdx = 0;
		
		int height = 0;
		
		for(int i=0; i<dump; i++) {
			//max, min 값 찾기 
			for (int v=0 ; v < boxes.length ; v++) {
				if (boxes[v] > maxNum) {
					maxNum = boxes[v];
					maxIdx = v;
				}
				if (boxes[v] < minNum) {
					minNum = boxes[v];
					minIdx = v;
				}
			}
			
			//높이 차 구하고 조건에 맞게 처리
			height = maxNum - minNum;
			
			if(height <= 1) break;
			else {
				maxNum -= 1;
				boxes[maxIdx] = maxNum;
				
				minNum += 1;
				boxes[minIdx] = minNum;
			}
		}
		return height;
	}

}












