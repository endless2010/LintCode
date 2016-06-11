import org.junit.Test;


/**
 * Your object will be instantiated and called as such:
 * ToyFactory tf = ToyFactory();
 * Toy toy = tf.getToy('Dog');
 * toy.talk(); 
 * >> Wow
 * 
 * toy = tf.getToy('Cat');
 * toy.talk();
 * >> Meow
 */
interface Toy {
    void talk();
}

class Dog implements Toy {
	public void talk(){
		System.out.println("Wow");
	}
}

class Cat implements Toy {
	public void talk(){
		System.out.println("Meow");
	}
}

public class ToyFactory {
    /**
     * @param type a string
     * @return Get object of the type
     */
    public Toy getToy(String type) {
        switch(type){
        case "Dog":
        	return new Dog();
        case "Cat":
        	return new Cat();
        default:
        	return null;
        }
    }    
	@Test
	public void test(){
		ToyFactory tf = new ToyFactory();
		Toy toy = tf.getToy("Dog");
		toy.talk(); 

		toy = tf.getToy("Cat");
		toy.talk();
	}
}
