# Assert fail
#def avg(marks):
#    assert len(marks) != 0, "List is empty."
#    return sum(marks) / len(marks)


# Assert and continue
def avg2(marks):
    try:
        assert len(marks) != 0
    except AssertionError:
        return "No marks entered"
    return sum(marks) / len(marks)

#mark1 = []
#print("Average of mark1:", avg2(mark1))

mark2 = [40, 20, 80]
print("Average of mark2:", avg2(mark2))
