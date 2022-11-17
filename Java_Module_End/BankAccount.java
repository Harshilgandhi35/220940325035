import java.util.*;


class WithDrawException extends Exception{
    WithDrawException(String msg)
    {
        super(msg);
    }
}


public class BankAccount {
    int accno;
    double balance;
    BankAccount(int accno,double balance)
    {
        this.accno = accno;
        this.balance = balance;

    }
    void withdraw(double b)
    {
        balance = balance - b;


    }
    void deposite(double b)
    {
        balance = balance + b;

    }
    void show()
    {
        System.out.println("account no is : "+accno);
        System.out.println("your balance is : "+balance);

    }
    public static void main(String[] args) throws WithDrawException{
        boolean x = true;
        Scanner sc = new Scanner(System.in);
        double balance;
        System.out.println("enter balance");
        balance = sc.nextDouble();
        BankAccount b = new BankAccount(1, balance);
        System.out.println("Bank");
        
        System.out.println("1.withdraw");
        System.out.println("2.deposit");
        System.out.println("3.show");
        System.out.println("4.exit");
        int choice;
        
        while(x)
        {
            System.out.println("enter your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("how many amount you have to withdraw");
                    double w =sc.nextDouble();
                    if (w > b.balance)
                    {
                        throw new WithDrawException("insufficient balance");
                    }
                    else{
                        b.withdraw(w);
                    }
                    break;
                    
                case 2:
                    System.out.println("how many amount you want to deposit");
                    double d = sc.nextDouble();
                    b.deposite(d);
                    break;
            
                case 3:
                    b.show();
                    break;

                case 4:
                    x =false;
                    break;

            }
        }

        



    }
    
}
