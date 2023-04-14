# Convert character to emojis based on user input
def convert_emoji(message):
    words = user_input.split(" ")
    emojis = {
        ":)": "😊",
        ":(": "😩",
        ":D": "🤣"
    }
    output = ""
    for word in words:
        output += emojis.get(word, word) + " "
    return output   # the variable returned is displayed on the terminal output when we called the fn.


user_input = input("> ")
print(convert_emoji(user_input))

