import random

numero = random.randint(1,100)
print("Este jogo é um adivinhe um número\nchute um numero entre 0 e 100 e tente a sorte!")
while True:
	a = int(input())
	if a == numero:
		print("Parabéns, você acertou!")
		break
	elif a < numero:
		print("Chute mais alto!")
	elif a > numero:
		print("Tá voando alto dms pae!!!")