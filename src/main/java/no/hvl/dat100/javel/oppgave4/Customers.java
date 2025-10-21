package no.hvl.dat100.javel.oppgave4;
import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;
import javax.xml.namespace.QName;

// oppretter customers klasse for å lage metoder som kan brukes på objektene
public class Customers {

    private Customer[] customers;

    public Customers(int size) {
        customers = new Customer[size]; //oppretter tabellen customers slik at en kan oppbevare og endre -
        // informasjon i objektvariabelene

    }


    // b) count number of non-null references
    public int countNonNull() {
        int count = 0;
        for (Customer c : customers) { // løkken går gjennom alle plassene i tabellen
            if (c != null) { // vist c ikke er null økes count med 1
                count++;
            }
        }
        return count; // returnerer/sender verdien metoden kommer frem til til den som kaller på .
        // metoden
    }


    // c) return reference to customer with given id (if exists)
    public Customer getCustomer(int customer_id) {
        for (Customer c : customers) {
            if (c != null && c.getCustomerId() == customer_id) {
                return c; // Returner kunden hvis ID stemmer
            }
        }
        return null; // Returner null hvis ingen kunde ble funnet
    }



    // d) add a customer to the reference table
    public boolean addCustomer(Customer c) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) { //
                customers[i] = c; // vist plass i er tom legges c inn i plassen i
                return true; //  return true og false brukes for å vite om element c er blitt lagt -
            } // til plassen i og for å ha kontroll på hva som er hvor
        }
        return false;
    }

    // e) remove customer with given id from reference table
    public Customer removeCustomer(int customer_id) {
        for (int i = 0; i < customers.length; i++) { // kjører løkke gjennom alle kundene
            if (customers[i] != null && customers[i].getCustomerId() == customer_id) { // vist -
                Customer temp = customers[i]; // verdien til plassnummer i er ikke er lik null -
                // og verdien til plassnummer i er lik id nummeret til kunden da settes verdien-
                customers[i] = null; // til plassenummeret lik ny variabel temp og denne sette -
                return temp; // null, som betyr at verdien til plassnummeret er borte
            }
        }
        return null;
    }

    // f) hent alle kunder
    public Customer[] getCustomers() {
        int count = countNonNull();
        Customer[] activeCustomers = new Customer[count];
        int index = 0;
        for (Customer c : customers) {
            if (c != null) {
                activeCustomers[index++] = c;
            }
        }
        return activeCustomers;
    }
}

        // f) return reference table with all customers
        /* public Customer[] getCustomers () {

            Customer[] customers = null;

            // TODO

            return customers;
        }
    }

         */
