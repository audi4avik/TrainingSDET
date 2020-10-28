package JavaActivity1;

public class Car {
	// class variables
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	//constructor
	Car(){
		tyres = 4;
		doors = 4;		
	}
	
	//class methods which can be called from the main method
	public void displayCharacteristics() {
		System.out.println("Color of the Car: " + color);
		System.out.println("Make of the Car: " + make);
		System.out.println("Transmission of the Car: " + transmission);
		System.out.println("Number of doors on the car: " + doors);
	    System.out.println("Number of tyres on the car: " + tyres);
	}
	public void accelerate(){
		System.out.println("car is moving forward");
	}
	public void brake() {
		System.out.println("car has stopped");
	}
}
