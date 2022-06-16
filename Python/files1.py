import string

punctuation = string.punctuation
file = open("teste2.txt")
lines = file.readlines()
for i in lines:
    x = i.lower().split()
    print(x)
