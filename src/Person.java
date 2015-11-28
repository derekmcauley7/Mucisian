
public class Person {
//	Design a Class which represents a Person. 
//	It is to have a name field and observer and display methods
	
	//fields
	String name;
	
	//constructor
	public Person(String n){
		name= n;	
	}
	
	//methods

	public void display(){
		System.out.println(name);
	}
	
	public String getName(){
		return name;
	}
	
	public String setName(String n){
		name = n;
		return name;
	}
	
	
}
