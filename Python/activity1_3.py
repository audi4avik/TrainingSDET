# rock, paper & scissor game
player1 = input ("Enter player 1 name: ")  # Enter player names
player2 = input ("Enter player 2 name: ")  # Enter player names
# Get the choice
choices = ["rock", "paper", "scissor"]
player1_answer = input ("Enter player 1 choice: ")
player1_answer = player1_answer.lower()
player2_answer = input ("Enter player 2 choice: ")
player2_answer = player2_answer.lower()

if player1_answer in choices and player2_answer in choices:
    if player1_answer == player2_answer:
        print ("It's a Tie")
    elif player1_answer == choices[0] and player2_answer == choices[1]:
        print ("{} wins" .format(player1))
    elif player1_answer == choices[0] and player2_answer == choices[2]:
        print ("{} wins" .format(player1))
    elif player1_answer == choices[1] and player2_answer == choices[2]:
        print ("{} wins" .format(player2))
    elif player2_answer == choices[0] and player1_answer == choices[1]:
        print ("{} wins" .format(player2))
    elif player2_answer == choices[0] and player1_answer == choices[2]:
        print ("{} wins" .format(player2))
    else:
        print ("{} wins" .format(player1))
else:
    print ("invalid input, please try again")

