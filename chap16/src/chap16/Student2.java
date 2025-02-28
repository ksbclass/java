package chap16;
/*
 enum : 열거형. 범위내외 값만 사용
 */
public class Student2 {
	public enum Gender { MALE,FEMALE};
	public enum City { Seoul,Pusan};
	private String name;
	private int score;
	private Gender gernder;
	private City city;
	public Student2(String name, int score, Gender gernder, City city) {
		this.name = name;
		this.score = score;
		this.gernder = gernder;
		this.city = city;
	}
	
	public Student2(String name, int score, Gender gernder) {
		this(name, score, gernder, null);
	}

	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public Gender getGernder() {
		return gernder;
	}
	public City getCity() {
		return city;
	}
	@Override
	public String toString() {
		return "Student2 [name=" + name + ", score=" + score + ", gernder=" + gernder + "]";
	}
}
