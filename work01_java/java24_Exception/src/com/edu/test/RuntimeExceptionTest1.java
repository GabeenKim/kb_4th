package com.edu.test;
/* 
   컴파일 시에는 에러가 없는데 
   실행시점에서 에러가 발생...
   -> 컴파일러가 인지하지 못하기 때문
   
   명시적인 예외 처리하지 않고 
   바로 코드를 실행하는 경우
   ::
   SQLException 
   
   명시적인 예외처리 방법
   try, catch, finally, throws, throw
   
   try{
   		//예외 발생 가능 코드
   }catch((터진 예외 종류)Exception e){
   		//예외 발생하면 이곳으로 코드가 이동...여기서 예외 잡혔을 때 코드 
   }-> catch는 여러번 사용 가능(다른 종류의 예외면)
   	finally{
   		//예외 발생에 상관없이 무조건 작성해야 하는 코드 
   }
   
   
 */
public class RuntimeExceptionTest1 {

	public static void main(String[] args) {
		String[] str = {
			"Hello",
			"NO, I mean it",
			"Nice to meet you"
		};
		
		int i =0;
		
		while(i<=3) {
			try {
//				a();
//				b();
//				c();//예외 -> 그러면 catch로 -> 맞는 예외처리면 ->finally
//					//예외 -> 만약 다른 예외처리면 catch실행 X -> 그럼에도 finally
//				d();
				System.out.println(str[i]);//예외 발생 가능 코드 
				
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice catch1");
			}
			catch (ArithmeticException e) {
				System.out.println("Nice catch2");
			}
			catch (Exception e) {
				System.out.println("Nice catch3");
			}finally{
				
			}
			i++;	
		}
		
	}

}
