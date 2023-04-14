# Duplicate key is not allowed in dictionary
customer = {
    "name": "John Smith",
    "age": 32,
    "is_verified": True
}
print(customer["name"])
print(customer.get("age"))  # better way to retrieve key value
print(customer.get("birthDate", "10-01-1990"))  # returns a default value even if the key is not present

customer["name"] = "Jack Doohan"    # overwrite value of a key
print(customer["name"])

customer["profession"] = "Student"     # add a new key value pair (record) to the dictionary
print(customer)


