# Find number of occurrence of a string in a given sentence

sentence = "So, you might say, Claire walks her dog. In this complete sentence, Claire is the subject, walks is the verb, and dog is the object."
print(sentence)
findStr = input("Enter the string to search: ")

# Check the string is present before taking the count
if findStr in sentence:
    strCount = sentence.count(findStr)
    print("The word {} is repeated {} times".format(findStr, strCount))
else:
    print("Entered string is not present.")




