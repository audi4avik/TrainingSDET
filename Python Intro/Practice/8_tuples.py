# Tuples are immutable
numbers = (10, 20, 30, 20)
print(numbers)
print(numbers.count(20))
print(numbers.index(10))

# Unpacking
values = (2, 5, 8)
x, y, z = values
print(x, y, z)