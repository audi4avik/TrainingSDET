# Reverse words of a given string

testStr = "python is an easy language"
print("Given string: {}" .format(testStr))

# split words based on space and reverse
testStr = testStr.split()
# join function to join based on spaces. works on list items
reverseStr = ' '.join(reversed(testStr))


print("Reversed string: {}" .format(reverseStr))





