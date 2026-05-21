package org.example.creational;

import java.util.Scanner;

interface PaymentService {
    void pay();
}

class CashPayment implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Paying with cash");
    }
}

class CardPayment implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Paying by card");
    }
}

class PaymentServiceFactory {
    public static PaymentService produce(String type) {
        return switch(type) {
            case "cash" ->  new CashPayment();
            case "card" -> new CardPayment();
            default -> throw new IllegalArgumentException("Invalid payment method: " + type);
        };
    }
}

public class Factory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter payment method: ");
        String paymentMethod = scan.nextLine().toLowerCase();

        PaymentService paymentService = PaymentServiceFactory.produce(paymentMethod);

        paymentService.pay();

        scan.close();
    }
}
