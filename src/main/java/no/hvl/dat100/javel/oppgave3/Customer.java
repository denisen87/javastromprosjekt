package no.hvl.dat100.javel.oppgave3;

public class Customer {
    private String name;
    private String email;
    private int customer_id;
    private PowerAgreementType agreement;

    // TODO - object variables (attributes)
//konstruktør, objektvariabler som kan ta inn og oppbevare informasjon om objektet
    public Customer(String name, String email, int customer_id, PowerAgreementType agreement) {
        this.name = name;
        this.email = email;
        this.customer_id = customer_id;
        this.agreement = agreement;

        // TODO
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    public PowerAgreementType getAgreement() {
        return agreement;
    }

    public void setAgreement(PowerAgreementType agreement) {
        this.agreement = agreement;
    }

    // TODO - getter/setter methods for all objectvariables

    public String toString() {
        return "Customer ID: " + customer_id
                + "Name: " + name
                + "Email: " + email
                + "Agreement: " + agreement;
    }

    // TODO - toString method

}
