# include words of the teste.txt as keys in a dictionary

txt = open('teste.txt')
line = txt.readline().split()
dicti = {}
x = 0

for i in line:
    x = x + 1
    dicti[i] = x

print(dicti)

# Search in dictionary


def reverse_lookup(d, v):
    for k in d:
        if d[k] == v:
            print(k)
    if v not in d:
        raise ValueError


reverse_lookup(dicti, 10)
