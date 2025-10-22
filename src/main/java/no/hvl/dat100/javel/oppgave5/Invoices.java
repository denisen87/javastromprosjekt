package no.hvl.dat100.javel.oppgave5;

public class Invoices {
    public static void processInvoices(Invoice[] invoices) {
        // Gå gjennom alle fakturaene i arrayet
        for (int i = 0; i < invoices.length; i++) {
            // Beregn totalbeløpet for fakturaen
            invoices[i].computeAmount();
            // Skriv ut fakturaen på skjermen
            invoices[i].printInvoice();
            }
        }
    }






