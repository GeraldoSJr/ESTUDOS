class Calculadora:
    def __init__(self, a, b):
        self.valor_a = a
        self.valor_b = b

    def soma(self):
        return self.valor_a + self.valor_b

    def sub(self):
        return self.valor_a - self.valor_b

    def div(self):
        return self.valor_a / self.valor_b

    def mult(self):
        return self.valor_a * self.valor_b


print("Teste nossa calculadora\nDigite 2 numeros e veja as operações básicas feitas com ele. ")
num1 = int(input())
num2 = int(input())

calculadora = Calculadora(num1, num2)
print(calculadora.soma())
print(calculadora.sub())
print(calculadora.div())
print(calculadora.mult())
