class Point:  # classes to create the blueprint for objects
    x = 10  # class attribute

    def move(self):  # class methods
        print("move")

    def draw(self):
        print("draw")


# Instantiate objects of Point class
point1 = Point()  # point1 is an object
point1.draw()
point1.x = 10  # attribute of an object
print(point1.x)
