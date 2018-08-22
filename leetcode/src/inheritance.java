
public class inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parent p=new child();
		p.display();
	}
}


class parent{
	
	void display(){
		System.out.println("parent class");
	}
	
}

class child extends parent{
	
	void display(){
		System.out.println("child class");
	}
	
}
