class People:
    def __init__(self, name):
        self.name = name

    def talk(self):
        print(f"Hi there, I'm {self.name}")


john = People("John Smith")
print(john.talk())

bob = People("Bob Dee")
print(bob.talk())