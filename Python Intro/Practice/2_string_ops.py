# Print is a function as it is general to for a lot of objects, but upper is a method as it works only on strings
course = "Python for Beginners"
print(len(course))  # length of string
print(course.upper())
print(course.lower())
print(course.title())
print(course.find("g"))  # returns first appearance index. If not found then return -1
print(course.find("f", 5, 12))  # first occurrence of the letter “f” when you only search between positions 5 and 12
print("Python" in course)  # return boolean. Case-sensitive result
print(course.replace("for", "4"))  # replace a char or pattern

# Slicing on strings
print(course[0:])  # prints the whole string without end index
print(course[1:-1])  # last index string is not counted
print(course[0:10:2])  # prints index 0 to 9 every 2nd element
print(course[::-1])  # reverse string

fruit = 'Apple is a fruit.'
# count the number of words/chars in string
print(fruit.count('i'))

# starts / ends-with returns boolean (case-sensitive)
print(fruit.startswith('A'))

# replace string
print(fruit.replace('Apple', 'Orange'))

# split string (default is whitespace)
print(fruit.split('is', maxsplit=1))

# Formatting
fName = "John"
lName = "Doe"
msg = f"{fName} [{lName}] is a coder"
print(msg)