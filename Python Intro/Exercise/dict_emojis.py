# Convert character to emojis based on user input
user_input = input("> ")
words = user_input.split(" ")
emojis = {
    ":)": "😊",
    ":(": "😩",
    ":D": "🤣"
}
output = ""
for word in words:
    output += emojis.get(word, word) + " "
print(output)
