# Write a Python program that throws a NameError without stopping execution
try:
    print("Entered try block")
    print(x)
except NameError:
    print("x hasn't been defined yet.")
