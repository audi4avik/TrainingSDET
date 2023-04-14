# Calculate down payment based on good or bad credit. Price of house is $1M
has_good_credit = False
price = 1000000
if has_good_credit:
    payment = 0.10 * price
    print("Down payment: ${}" .format(payment))
else:
    payment = 0.20 * price
    print(f"Down payment: ${payment}")

has_high_income = True
if has_good_credit or has_high_income:  # any one of the condition should be true
    print("Eligible for Loan")
else:
    print("Not eligible")