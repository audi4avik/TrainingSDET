# Find largest number from a list
numbers = [1, 5, 10, 9, 8, 16, 18, 6, 11]
largestNum = numbers[0]
for i in range(len(numbers)):
    if numbers[i] > largestNum:
        largestNum = numbers[i]

print(f"Largest Num: {largestNum}")

print(max(numbers))


