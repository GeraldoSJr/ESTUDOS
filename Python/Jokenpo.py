import random as rd 

escolhas = ["tesoura", "papel", "pedra"]

escolhi = rd.choice(escolhas)
inp = input()
print(escolhi.capitalize())
def acertamos():
	if inp.lower() not in escolhas:
		print("Que diabos vc digitou irmao?")
	else:
		if inp.lower() == "tesoura" and escolhi == "papel":
			print("Droga! perdi.")
		elif inp.lower() == "tesoura" and escolhi == "pedra":
			print("Chuuuuppaaaaaaa!")
		elif inp.lower() == "papel" and escolhi == "pedra":
			print("Droga! perdi.")
		elif inp.lower() == "papel" and escolhi == "tesoura":
			print("Chuuuuppaaaaaaa!")
		elif inp.lower() == "pedra" and escolhi == "tesoura":
			print("Droga! perdi.")
		elif inp.lower() == "pedra" and escolhi == "papel":
			print("Chuuuuppaaaaaaa!")
if inp.lower() == escolhi:
	while True:
		print("It's a tie!\nVamos desempatar!")
		inp2 = input()
		escolha.random.choice(escolhas)
		if inp.lower == escolha:
			print("empatamos dnv\nMais uma vez!")
			pass
		else:
			acertamos()
else:
	acertamos()