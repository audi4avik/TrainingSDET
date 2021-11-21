# Check a string is palindrome or symmetrical

userInput = input("Enter your string: ")

# check even / odd number of chars
if len(userInput) % 2 == 0:
    firstStr = userInput[:len(userInput)//2]
    secondStr = userInput[len(userInput)//2:]
else:
    firstStr = userInput[:len(userInput) // 2]
    secondStr = userInput[len(userInput) // 2 + 1:]

if firstStr == secondStr:
    print("string is symmetrical")
else:
    print("string is not symmetrical")

if userInput == userInput[::-1]:
    print("string is palindrome")
else:
    print("string is not palindrome")