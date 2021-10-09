package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount("Счет клиента", 0.00);
        userAccount.deposit(20000);
        Scanner scanner = new Scanner(System.in);
        boolean isAmountEnough = false;
        while (true){
            try {
                if (!isAmountEnough){
                    System.out.println("Баланс счета: " + userAccount.getAmount());
                    userAccount.withdraw(6000);
                }
            } catch (LimitException limitException) {
                System.out.println(limitException.getMessage());
                isAmountEnough = true;
                int sumTowithdraw = 0;
                System.out.println("Введите желаюему сумму: " + sumTowithdraw);
                sumTowithdraw = scanner.nextInt();
                try {
                    userAccount.withdraw(sumTowithdraw);
                } catch (LimitException e) {
                    e.printStackTrace();
                }
                System.out.println("Остаток на счете: " + userAccount.getAmount());
                break;
            }

        }
    }
}
