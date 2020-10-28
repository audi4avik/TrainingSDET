package JavaActivity1;

public class Activity1_1 {
	public static void main(String[] args) {
		// created "honda" object of "Car" class
		Car honda = new Car();
		// initialize the properties 
		honda.make = 2019;
		honda.color = "red";
		honda.transmission = "Automatic";
				
		// Call the methods from Car class created inside the package
		honda.displayCharacteristics();
		honda.accelerate();
		honda.brake();
		
	}
}
