package homework;

public class Student{		
	int id;
	String bj;
	String name;
	
	//������κ���
	public Student(String bj,int id,String name){
		this.bj=bj;
		this.id=id;
		this.name=name;		
	}
	
	//�����޲ι��캯��
	public Student(){}

	public String getBj() {
		return bj;
	}

	public void setBj(String bj) {
		this.bj = bj;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
	
	