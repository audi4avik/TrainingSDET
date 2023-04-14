# Convert number to words from user input
numbers = input("Please enter the numbers: ")
word_map = {
    "1": "One",
    "2": "Two",
    "3": "Three",
    "4": "Four"
}
output = ""

for num in numbers:
    # defaulting value NA if entered digit is not found in the dictionary
    output += word_map.get(num, "NA") + " "     # concatenate space
print(output)