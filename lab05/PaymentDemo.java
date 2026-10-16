// Version A: instanceof pattern matching (type-checking in the caller)
class Payment { }

class CardPayment extends Payment {
    String cardNumber = "4111-1111";
}

class MobileMoneyPayment extends Payment {
    String phone = "+263771234567";
}

class PaymentProcessorA {
    static void pay(Payment p) {
        if (p instanceof CardPayment c) {
            System.out.println("Charging card " + c.cardNumber);
        } else if (p instanceof MobileMoneyPayment m) {
            System.out.println("Requesting mobile money from " + m.phone);
        } else {
            throw new IllegalArgumentException("Unknown payment type");
        }
    }
}

// Version B: polymorphic process() (each type knows how to pay)
abstract class Payment2 {
    abstract void process();
}

class CardPayment2 extends Payment2 {
    String cardNumber = "4111-1111";
    @Override void process() { System.out.println("Charging card " + cardNumber); }
}

class MobileMoneyPayment2 extends Payment2 {
    String phone = "+263771234567";
    @Override void process() { System.out.println("Requesting mobile money from " + phone); }
}

class PaymentProcessorB {
    static void pay(Payment2 p) { p.process(); }   // no type checks at all
}

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentProcessorA.pay(new CardPayment());
        PaymentProcessorA.pay(new MobileMoneyPayment());

        PaymentProcessorB.pay(new CardPayment2());
        PaymentProcessorB.pay(new MobileMoneyPayment2());
    }
}
