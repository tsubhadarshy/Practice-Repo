package session1;

public class Car {
    //Class Member Variables
    String color;
    int make;
    String transmission;
    int tyres;
    int doors;
	
    //Constructor
    Car(int tyres, int doors) {
    	this.tyres = tyres;
    	this.doors = doors;
    }

    Car() {
    	this.tyres = 4;
    	this.doors = 4;
    }

    //Class Methods
    public void displayCharacterstics() {
    	System.out.println("Color of the Car: " + color);
    	System.out.println("Make of the Car: " + make);
    	System.out.println("Transmission of the Car: " + transmission);
    	System.out.println("Number of doors on the car: " + doors);
    	System.out.println("Number of tyres on the car: " + tyres);
    }

    public void accelerate() {
    	System.out.println("Car is moving forward.");
    }
	
    public void brake() {
    	System.out.println("Car has stopped.");
    }
}