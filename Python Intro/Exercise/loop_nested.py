# Nested Loop Solution
list = [5, 2, 5, 2, 2]
for x in list:
    output = ""
    for i in range(x):
        output+= "x"
    print(output)


# Short solution
# x = [5, 2, 5, 2, 2]
# for item in x:
#     print("x" * item)
