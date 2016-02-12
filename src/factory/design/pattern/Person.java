package factory.design.pattern;

public class Person {

    private String name;

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
    	return name;
    }
    
    public void doSomething(Person p) {
        p.setName("Mike");
        p = new Person();
        p.setName("Chris");
    }


public static void main(String args[]) {

	 	Person p = new Person();
	 	
	    p.setName("Frank");
	    
	    System.out.println(p.getName());
	    
	    p.doSomething(p);
	    
	    System.out.println(p.getName());
	    
}

}
