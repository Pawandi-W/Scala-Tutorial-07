var accountList:List[Account] = List()

def accCreate(nic:String, accId: Int):Unit = {
    val acc = new Account(nic, accId)
    accountList = accountList ::: acc :: Nil
    println(accountList)
}
//Q4
val find = (a:Int, b:List[Account]) => b.filter(account => account.accId.equals(a))
val overdraft = (b:List[Account]) => b.filter(account => account.balance < 0.0)
val totalBalance = (b:List[Account]) => b.foldLeft(0.0)((x, y) => x + y.balance)
val interest = (b:List[Account]) => b.map(account => if(account.balance > 0) account.balance*0.05 else account.balance*0.1)


accCreate("1",1)
accCreate("2",2)
accCreate("3",3)

//deposit money
find(1, accountList)(0).deposit(1000)
//transfer money
find(1, accountList)(0).transfer(2, 100.0)
// Negative Balance
find(3, accountList)(0).transfer(2, 100.0)

//list of negative balances
println("Negative Balance: " + overdraft(accountList))

//sum of all account balances
println("Total Balance: " +totalBalance(accountList))

//final balances of all accounts after apply the interest
println("Intrest Balance: " + interest(accountList))

class Account(nic:String, val accId: Int, var balance: Double = 0.0){
// Q3
def withdraw(amount:Double) : Unit = {
    this.balance = this.balance - amount
}

def deposit(amount:Double) : Unit = {
    this.balance = this.balance + amount
}

def transfer(account:Int, amount:Double) : Unit = {
    val transferAcc = find(account, accountList)
    if (balance < 0.0) println("Insufficient balance")
    else {
      this.withdraw(amount);
      transferAcc(0).deposit(amount);
    }
}
override def toString = "[ Nic: "+ nic + "| Acc_No :" + accId + "| Balance : "+ balance+"]"
}
