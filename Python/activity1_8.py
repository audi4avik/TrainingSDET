# Given a list of numbers, return True if first and last number of a list is same.
myList = list(input("Enter list items separated by single space: ").split(" "))

if myList[0] == myList[-1]:
    print ("True")
else:
    print ("The first and last number is not the same")
