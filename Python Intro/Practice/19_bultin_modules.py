import random
import os
import math
import datetime
from pathlib import Path

# generating random number
for i in range(3):
    print(random.randint(10, 100))

# choose random member
members = ["Mary", "John", "Jane", "Bob"]
print(random.choice(members))

# working with files & dirs
print(os.getcwd())

# print the value of pi
print(math.pi)

# system date
print(datetime.date.today())

# path
path = Path()
for file in path.glob('*'):
    print(file)