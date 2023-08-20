package spring.service.dice.play;
//DiceA, B, C가 가지고 있는 핵심 기능의 추상 메소드, 템플릿 
public interface Dice {
	void selectedNumber();
	int getValue();
}
