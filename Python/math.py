#Learning how to use the Math module
#Trying some simple geometric calculus

import math

print("Type a number and I'll show u the geometric\ncalculus assumpting this number was a radius!")

radius = float(input())
pi = round(math.pi,2)
print(pi)
circumference = 2 * radius * pi
circleSarea = (radius * pi) ** 2
sphereSvolume = (4 * pi * radius ** 3) / 3

print(f"Circumference: {circumference}")
print(f"The area of the circle: {circleSarea}")
print(f"The volume the sphere: {sphereSvolume}")