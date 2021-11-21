'''
Create a Python dictionary that contains a bunch of fruits and their prices.
Write a program that checks if a certain fruit is available or not.
'''
fruitDict = {'apple': 80, 'orange': 50, 'banana': 20, 'grapes': 65, 'mango': 130}

checkItem = input ("Enter the fruit you're looking for: ").lower()

if checkItem in fruitDict:
    print ("{} is available and the price is {}".format(checkItem, fruitDict[checkItem]))
else:
    print ("Fruit is not available")
