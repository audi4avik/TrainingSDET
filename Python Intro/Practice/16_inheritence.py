# DRY - don't repeat yourself
class Mammal:       # parent class having the common properties which can be reused in child classes
    def walk(self):
        print("can walk")


class Dog(Mammal):  # Dog is inheriting all the methods from parent class
    pass    # python throws error for empty class. 'pass' statement bypasses it


class Cat(Mammal):
    def meow(self):     # along with the inherited class, Cat can have own specific method
        print("cats can meow")


dog1 = Dog()
dog1.walk()
cat1 = Cat()
cat1.meow()