"""
1. variales
2. conditional
3. loop
4. arrays / list
5. user defined methods
"""


x = "hello friends"
print(x)
print(type(x))  #type will give data type of the variable

x = -90
if x > 0:
    print("positive")
elif x < 0:
    print("negative")
else:
    print("nutral")

i = 0
while i <= 2:
    print(i)
    i = i + 1

a = (5, 88, 12)
for i in a:
    print(i)



def sample():
    print("hello world")
    print("hello friends")

sample()

def sum(x, y):
    print (x + y)

sum(30, 45)

def subtract(a, b):
    return a - b

print(subtract(45, 25))
