class Mobile:
    # class attribute
    os = "null"
    cost = 0

    # constructor
    def __init__(self, os, cost):
        self.os = os
        self.cost = cost


sony = Mobile("Android", 750)
iphone = Mobile("iOS", 800)

# print("{} is {} years old".format(sony.os, sony.cost))
# print("{} is {} years old".format(iphone.os, iphone.cost))

print(sony.os)
print(sony.cost)
