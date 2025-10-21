package no.hvl.dat100.javel.oppgave3;

import no.hvl.dat100.javel.oppgave4.Customers;

public class CustomerMain {
// fyller inn objektvariablene med diverse informasjon
    public static void main(String[] args) {
        Customer c1 = new Customer("Ola Nordmann ", "ola@nordmann.no",101, PowerAgreementType.SPOTPRICE);
        System.out.println(c1);
        Customer c2 = new Customer("Denis Fonnes ","denisen87@hotmail.com",1,PowerAgreementType.NORGESPRICE);
        System.out.println(c2);
        Customer c3 = new Customer("Jan Hansen ", "jan@hansen.no", 2, PowerAgreementType.POWERSUPPORT);
        System.out.println(c3);
        Customer c4 = new Customer("Ivar Bergsvik", "ola@nordmann.no", 101, PowerAgreementType.LAVESTPRIS);
        System.out.println(c4);
// legger til metoder som gjør at objektvariablene utfører ulike funksjoner



        /*
        TODO

         Write code that creates a Customer object and teste the methods implemented in the class

        */
    }
}
