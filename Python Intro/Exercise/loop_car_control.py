# Write a program to start and stop a car based on user input text. Typing quit kills the program.
user_input = ""
car_started = False
while True:
    user_input = input("> ").lower()
    if user_input == "start":
        if car_started:  # translates to if True
            print("car is already started")
        else:
            print("Start the car")
            car_started = True  # set the var value
    elif user_input == "stop":
        if not car_started:     # check the opposite condition translates to car_started = False
            print("car is already stopped")
        else:
            print("Stop the car")
            car_started = False  # set the var value
    elif user_input == "help":
        print("""
    Start -> Start the Car
    Stop -> Stop the Car
    quit -> Quit the program
    """)
    elif user_input == "quit":
        print("Program Terminated")
        break
    else:
        print("Invalid input")
