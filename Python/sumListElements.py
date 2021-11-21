# Write a Python program to calculate the sum of all the elements in a list.
userList = list(input("Enter list elements separated by comma: ").split(','))
print ("User input has been stored into: ", userList)
sum = 0

for num in userList:
    sum += int(num)
print (sum)