# Swap 2 variable values without using a third variable - uses string slicing

var1 = 'Avik'
var2 = 'Datta'

var1 = var1 + var2

var2 = var1[:(len(var2)-1)]
var1 = var1[len(var2):]

print(var1, var2)

