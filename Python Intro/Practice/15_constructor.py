# constructor is a function which gets called while creating an object
class Point:
    def __init__(self, x, y):  # this is a constructor -> self is a reference to the current object i.e. point1
        self.x = x  # attribute (x) of the current object is referred to the (x) argument of the above function
        self.y = y

    def move(self):  # class methods
        print("move")


point1 = Point(10, 20)  # point1 is an object
print(point1.x)
point1.y = 12   # overriding the argument value pass to the constructor
print(point1.y)
