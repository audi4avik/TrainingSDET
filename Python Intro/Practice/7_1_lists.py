names = ["Avik", "John", "Jane", "Mosh"]
print(names)
print(names[2])
print(names[-1])  # last element index
names[1] = "Jacob"
print(names[0:3])

numbers = [1, 2, 3, 4, 5]
print(numbers)
numbers.append(6)
print(numbers)
numbers.insert(0, -1)
numbers.remove(3)
print(numbers)
numbers.clear()
print(numbers)

numbers = [1, 2, 3, 4, 5, 5]
print(5 in numbers)  # returns boolean
print(numbers.count(2))
print(numbers.index(3))

print(len(numbers))
print(numbers.sort())  # sorted in asc order
print(numbers.reverse())  # sorted in desc order

number2 = numbers.copy()  # copy a list
