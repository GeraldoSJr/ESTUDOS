string = input()
n_rotate = int(input())


def rotate_word(s, n):
    new_word = ""
    for c in s:
        new_c = chr(ord(c) + n)
        new_word = new_word + new_c
    print(new_word)


rotate_word(string, n_rotate)
