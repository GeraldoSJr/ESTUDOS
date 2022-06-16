a = input()
b = input()
c = int(input())


def search(word, letter, index):
    for i in range(index, len(word)-1):
        if word[i] == letter:
            # return index
            print(index)
    # return -1
    print(-1)


search(a, b, c)
