package ChainOfResponsibilityPattern;

/**
 * DespenseChain
 */
interface DispenseChain {
    void setNextChain(DispenseChain nextChain);

    void dispense(Currency currency);
}

/**
 * Currency
 */
class Currency {
    private int amount;

    public Currency(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}

/**
 * Doller50Dispenser
 */
class Doller50Dispenser implements DispenseChain {

    private DispenseChain dispenseChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.dispenseChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 50) {
            int num = currency.getAmount() / 50;
            int remainder = currency.getAmount() % 50;
            System.out.println("Dispensing " + num + " 50$ note.");
            if (remainder != 0) {
                this.dispenseChain.dispense(new Currency(remainder));
            }
        } else {
            this.dispenseChain.dispense(currency);
        }
    }

}

/**
 * Doller20Dispenser
 */
class Doller20Dispenser implements DispenseChain {

    private DispenseChain dispenseChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.dispenseChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 20) {
            int num = currency.getAmount() / 20;
            int remainder = currency.getAmount() % 20;
            System.out.println("Dispensing " + num + " 20$ note.");
            if (remainder != 0) {
                this.dispenseChain.dispense(new Currency(remainder));
            }
        } else {
            this.dispenseChain.dispense(currency);
        }
    }

}

/**
 * Doller20Dispenser
 */
class Doller10Dispenser implements DispenseChain {

    private DispenseChain dispenseChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.dispenseChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 10) {
            int num = currency.getAmount() / 10;
            int remainder = currency.getAmount() % 10;
            System.out.println("Dispensing " + num + " 10$ note.");
            if (remainder != 0) {
                this.dispenseChain.dispense(new Currency(remainder));
            }
        } else {
            this.dispenseChain.dispense(currency);
        }
    }

}

public class ChainOfResponsibilityPattern {

    private DispenseChain c1;

    public ChainOfResponsibilityPattern() {
        this.c1 = new Doller50Dispenser();
        DispenseChain c2 = new Doller20Dispenser();
        DispenseChain c3 = new Doller10Dispenser();
    }

}
