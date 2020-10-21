package session1;

public class Activity1_1 {

    public static void main(String[] args) {
	    // Object initialization
	    Car toyota = new Car();
		// Add default values
	    toyota.make = 2015;
	    toyota.color = "Black";
	    toyota.transmission = "Manual";
	    toyota.modelNumber = "qpri134";
	    toyota.model = "Honda";
	
//Forked sahil's repo		//Using Car class method
		toyota.displayCharacterstics();
		toyota.accelerate();
		toyota.brake();
    }

}
