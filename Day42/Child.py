from Parent import Bank


class Savings(Bank):
    acct_type = ""

    def __init__(self, ac_type, fn, ln):
        self.acct_type = ac_type
        super().__init__(fn, ln)

    def display(self):
        print(self.first_name + ' ' + self.last_name)
        print("Account Type: " + self.acct_type)

