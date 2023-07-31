package net.kdigital.fitness.vo;

public class Fitness {
	//회원id(문자열), 회원이름(문자열), 키(실수), 몸무게(실수), bmi(실수)
	private String id;
	private String name;
	private double height;
	private double weight;
	private double bmi;
	
	// 기본생성자 
	public Fitness() {
		super();
	}
	
	// 오버로드 생성자 
	public Fitness(String id, String name, double height, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		calcBmi();  // 키와 몸무게가 바로 입력되는 순간 bmi 계산을 하도록 
	}
	
	// getter, setter 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
		calcBmi();
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
		calcBmi();
	}
	
	public double getBmi() {
		return bmi;
	}

	private void calcBmi() {
		this.bmi = this.weight/ ((this.height*0.01)*(this.height*0.01));
	}
	
	//tostring 
	@Override
	public String toString() {
		return "회원 ID: " + id +"\n"+ "회원 이름:" + name +"\n"+ "키(cm)" + height +"\n"+ "몸무게(kg)" + weight 
				+"\n"+ "회원 Bmi : " + bmi;
	}
	
	
	
	
}
