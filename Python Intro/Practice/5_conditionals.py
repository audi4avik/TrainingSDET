temperature = 14
if temperature > 25:
    print("It's a hot day")
elif temperature < 15:
    print("A bit cold today")
else:
    print("Normal breeze")
print("That's all for today's weather.")

# Exercise
weight = int(input("Enter your weight: "))
unit = input("Choose conversion unit (K)g or (L)bs: ")
if unit.upper() == "K":
    print("The weight in kg is: " + str(weight / 2.204))
elif unit.upper() == "L":
    print("The weight in pound is: " + str(weight * 2.204))
else:
    print("Invalid option.")
