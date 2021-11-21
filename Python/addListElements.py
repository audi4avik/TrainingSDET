# Write a function sum() such that it can accept a list of elements and print the sum of all elements

def sum (elements): # Function parameter
    result = 0
    for num in elements:
        result += float(num)
    return result


numberList = list(input("Enter numbers separated by comma: ").split(","))
print ("The sum of the numbers is: ", sum(numberList)) # passing argument to the function after taking input from user