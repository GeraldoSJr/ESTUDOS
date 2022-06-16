# First program checks if a list it is sorted

lis = ['a', 'b', 'c', 'f', 'g', 'k', 'x']


def is_sorted(k):
    a = 0
    for i in range(len(k)-2):
        if k[i] < k[i+1]:
            a = 1
    if a == 1:
        print(True)


is_sorted(lis)

# Second program checks if words are anagrams

print("Type 2 words and checks to see if they are anagrams: ")
s1 = input()
s2 = input()


def is_anagram(a, b):
    a2 = list(a.lower())
    b2 = list(b.lower())
    a2.sort()
    b2.sort()
    if a2 == b2:
        print(True)


is_anagram(s1, s2)
