# Build a number guessing game with 3 tries. User wins if guess is correct in any try.
number_to_guess = 14
max_tries = 3
guess_count = 0

while guess_count < max_tries:
    input_number = int(input("Enter the number to try: "))
    guess_count += 1
    if input_number == number_to_guess:
        print("You Win!")
        break
else:   # else block for while loop if loop doesn't break out
    print("You Failed!")
