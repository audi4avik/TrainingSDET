try:    # try block to write the code which to be executed without failing (exit code = 1) the whole program
    age = int(input("Enter age: "))
    income = 20000
    risk = income / age
    print(risk)
except ZeroDivisionError:   # specific exception name is written here
    print("Age can't be 0")
except ValueError:  # the exception which the above code block might raise and handling with a message
    print("Invalid Value Error")

"""
List of Common Exceptions:
AssertionError	Raised when an assert statement fails.
FloatingPointError	Raised when a floating point operation fails.
IndexError	Raised when the index of a sequence is out of range.
KeyError	Raised when a key is not found in a dictionary.
NameError	Raised when a variable is not found in local or global scope.
RuntimeError	Raised when an error does not fall under any other category.
SyntaxError	Raised by parser when syntax error is encountered.
ValueError	Raised when a function gets an argument of correct type but improper value.
ZeroDivisionError	Raised when the second operand of division or modulo operation is zero.
"""