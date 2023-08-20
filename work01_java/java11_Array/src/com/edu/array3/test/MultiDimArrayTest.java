package com.edu.array3.test;
/*
 * 행: 반의 개수 / 열: 각 학생들의 점수
 */

public class MultiDimArrayTest {

	public static void main(String[] args) {
		
		//학생 수가 3명으로 동일한 반 2개 생성
		int[][] mathScore = new int[2][3];
		
		for(int i=0;i<mathScore.length;i++) {
			for(int j=0; j <mathScore[i].length ; j++) {
				System.out.println("math["+i+"]["+j+"] = " + mathScore[i][j]);
			}
		}
		
		System.out.println("==============");
		mathScore[0][0] = 80;
		mathScore[0][1] = 82;
		mathScore[0][2] = 84;
		mathScore[1][0] = 86;
		mathScore[1][1] = 90;
		mathScore[1][2] = 92;
		
		int totalStudent = 0;
		int totalMathSum = 0;
		
		for(int i=0;i<mathScore.length;i++) {
			totalStudent += mathScore[i].length;
			
			for(int j=0; j <mathScore[i].length ; j++) {
				totalMathSum += mathScore[i][j];
			}
		}
		
		double mathAvg = (double) totalMathSum / totalStudent;
		System.out.println("전체 학생의 수학 평균 점수 = "+mathAvg);
		System.out.println("==============");
		
		//학생 수가 다른 두 반 생성. 학생 수가 다르므로 점수 저장공간은 비워두고 반 공간만 생성한다.
		int[][] englishScore = new int[2][];
		
		//그 후 각 반에 각 학생 수만큼의 공간 생성
		englishScore[0]= new int[2];
		englishScore[1]= new int[3];
		
		for(int i=0;i<englishScore.length;i++) {
			for(int j=0; j <englishScore[i].length ; j++) {
				System.out.println("english["+i+"]["+j+"] = " + englishScore[i][j]);
			}
		}
		
		System.out.println("==============");
		englishScore[0][0] = 80;
		englishScore[0][1] = 82;

		englishScore[1][0] = 86;
		englishScore[1][1] = 90;
		englishScore[1][2] = 92;
		
		totalStudent = 0;
		int totalEnglishSum = 0;
		
		for(int i=0;i<englishScore.length;i++) {		//반의 수 만큼 반복
			totalStudent += englishScore[i].length; 
			
			for(int j=0; j <englishScore[i].length ; j++) {	//학생 수 만큼 반복
				totalEnglishSum += englishScore[i][j];
			}
		}
		
		double englishAvg = (double) totalEnglishSum / totalStudent;
		System.out.println("전체 학생의 수학 평균 점수 = "+englishAvg);
	}

}
