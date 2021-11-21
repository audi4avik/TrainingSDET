# Methods are functions run against an object i.e. object.method()
fruit = 'Apple is a fruit.'

print(fruit.lower())
print(fruit.upper())
print(fruit.title())

# String Concatenation
version = 3
print("I love python " + str(version))

# String repeat
print("happy " * 3)

# count the number of words/chars in string
print(fruit.count('i'))

# find the index of the given char
print(fruit.find('is'))

# Where in the text is the first occurrence of the letter “d” when you only search between positions 5 and 16?
string = "analytics vidhya is the Largest data science Community"
print(string.find("d", 5, 16))

# starts / ends-with returns boolean (case sensitive)
print(fruit.startswith('A'))

# replace string
print(fruit.replace('Apple', 'Orange'))

# split string (default is whitespace)
print(fruit.split('is', maxsplit=1))

# String slicing and reversing
String = 'Alaska'
print(String[:3])
print(String[1:5:2])

print(String[::-1])