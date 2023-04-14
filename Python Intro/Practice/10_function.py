# Functions are reusable block of codes which performs something specific
def greet_function():   # function definition
    print("Hi there!")
    print("Welcome aboard :)")


print("Start")      # execution starts
greet_function()    # function called here
print("Finish \n")     # execution ends


# Pass value to the same function
def greet_name(first_name):   # this is called fn. parameter - which is placeholder for receiving information
    print(f"Hi, {first_name}")
    print("Welcome aboard :)")


print("Start")      # execution starts
greet_name("John")      # passing information to the function - this is called argument
greet_name("Jane")
print("Finish")     # execution ends
