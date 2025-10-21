package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class CustomersMain {

    public static void main(String[] args) {
        Customers customerList = new Customers(4);
        // Lager nytt objekt – konstruktøren setter verdier i objektvariablene
        Customer c1 = new Customer("Alice ", "alice@gmail.com", 1, PowerAgreementType.SPOTPRICE);
        Customer c2 = new Customer("Anders ", "anders@example.com", 2, PowerAgreementType.SPOTPRICE);
        Customer c3 = new Customer("Åge Kleppe ", "åge@example.com", 3, PowerAgreementType.POWERSUPPORT);
        Customer c4 = new Customer("Linda Hjelde ", "hjelde@example.com", 3, PowerAgreementType.LAVESTPRIS);

        customerList.addCustomer(c1);
        customerList.addCustomer(c2);
        customerList.addCustomer(c3);
        customerList.addCustomer(c4);


        // bruker metoden countNonNull for å beregne antall kunder totalt
        int antall = customerList.countNonNull();
        System.out.println("Antall kunder registrert: " + antall);


        // bruker metoden getCustomer for å hente kunde
        Customer hentetKunde = customerList.getCustomer(2); // må ha data typen Customer med -
        //   når hentekunde variabelen defineres første gang
        if (hentetKunde != null) {
            System.out.println("Kunde funnet: " + hentetKunde.getName()
                    + ", Email: " + hentetKunde.getEmail());
        } else {
            System.out.println("Ingen kunde med den ID-en ble funnet.");
        }
        System.out.println("\nAntall kunder før sletting: " + customerList.countNonNull());

// sletter kunde
        Customer slettet = customerList.removeCustomer(2);

        if (slettet != null) {
            System.out.println("Slettet kunde: " + slettet);
        } else {
            System.out.println("Fant ingen kunde med ID 2 å slette.");
        }

        System.out.println("Antall kunder etter sletting: " + customerList.countNonNull());

// Skriv ut alle kunder etter sletting for å se at den faktisk er borte
        System.out.println("\nKunder igjen i systemet:");
        for (Customer c : customerList.getCustomers()) {
            System.out.println(c);
        }

        // hente alle kunder
        System.out.println("Alle registrerte kunder:");
        Customer[] kundeliste = customerList.getCustomers(); // henter ut alle kundene fra tabellen
        for (Customer c : kundeliste) { // går gjennom hver kunde i tabellen
            System.out.println(c); // printer ut kunden (bruker automatisk toString())
        }


    }
}














        /*
        TODO

         Write code that uses and tests the methods implemented in the Customers class

        */


