package com.edu.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReading{
	public void readFile(String filename) {
		FileReader reader = null;
		try {
			//stream 
			 reader = new FileReader(filename);
			
			System.out.println("1. 파일을 찾았습니다.");
			
			
		}catch(FileNotFoundException e) {
			System.out.println("1. 파일을 찾을 수가 없습니다.");
		
		}catch(IOException e) {
			System.out.println("1. 파일을 찾을 수가 없습니다.");
		
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
		}
		
		System.out.println("2. FileReader API...");
		
		
	}
}
}
public class CompileTest2 {
	public static void main(String[] args) {
		FileReading fr = new FileReading();
		fr.readFile("C:\\KB_EDU\\doc\\KB_WS06_JAVA.pdf");// 읽어드리고 싶은 파일의 경로 
		fr.readFile("C:\\KB_EDU\\doc\\KB_WS06_JAVA1.pdf");
		System.out.println("3. readFile() calling");
		
	}
}
