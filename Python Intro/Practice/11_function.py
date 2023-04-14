def greet_name(first_name, last_name):  # this is called parameter - which is placeholder for receiving info
    print(f"Hi, {first_name} {last_name}")
    print("Welcome aboard :)")


print("Start")  # execution starts
greet_name("John", "Smith")  # positional argument
# greet_name("Jane")  # this function will not be called as we are passing only one parameter
print("Finish \n")  # execution ends


# Another way
def greet_fullname(first_name, last_name):
    print(f"Hi, {first_name} {last_name}")
    print("Welcome aboard :)")


print("Start")
greet_fullname(last_name="Smith", first_name="John")  # keyword args. helpful with passing numbers to identify better
greet_fullname("Jacob", last_name="Smith")  # positional arg should always come first in this case
print("Finish")
