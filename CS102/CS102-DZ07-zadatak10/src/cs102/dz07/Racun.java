package cs102.dz07;

import java.util.Objects;

public class Racun{
    private String name;
    private String accountNumber;

    public Racun() {
    }

    public Racun(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + Objects.hashCode(this.accountNumber);
        return hash;
    }

    @Override
    public String toString() {
        return "Vlasnik: " + name + "/n" + "Broj Racuna: " + accountNumber;
    }

}
