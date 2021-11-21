"""
Given a tuple of numbers, iterate through it and print only those 
numbers which are divisible by 5
"""

myTuple = (5, 6, 20, 33, 45, 62)
print("Given list is ", myTuple)

for element in myTuple:
    if (element % 5 == 0):
        print (element)