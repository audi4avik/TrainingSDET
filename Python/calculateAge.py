# Calculate year when you will turn 100
from datetime import date
initDate = date.today()
age = int (input("enter your age: "))
d1 = initDate.strftime("%Y")
newYear = 2020 + (100 - age)
print ("You will be 100 in: {}" .format(newYear))