"""
Given a two list of numbers create a new list such that new list should contain 
only odd numbers from the first list and even numbers from the second list.
"""
firstList = [10, 11, 23, 25, 28, 30]
secondList = [99, 77, 60, 91, 80]
finalList = []

for item in firstList:
    if (item % 2 > 0):
        finalList.append(item)


for item in secondList:
    if (item % 2 == 0):
        finalList.append(item)

print (finalList)
