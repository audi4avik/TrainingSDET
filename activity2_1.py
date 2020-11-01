# Write a Python program that throws a NameError without stoping execution
try:
    print("Entered try block")
    print(x)
except NameError:
    print("x hasn't been defined yet.")
