# Write a program that asks the user how many Fibonnaci numbers to generate and then generates them.
def fibo (num):
    if num <= 1:
        return num
    else:
        return (fibo(num-1) + fibo (num-2))

userInput = int(input("Enter the desired number to generate the fibonacci series: "))
for i in range(userInput):
        print(fibo(i))