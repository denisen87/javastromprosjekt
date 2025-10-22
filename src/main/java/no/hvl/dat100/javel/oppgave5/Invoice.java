package no.hvl.dat100.javel.oppgave5;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave2.MonthlyPower;

public class Invoice {

    private Customer c; // customer associated with this invoice
    private String month; // month that the invoice covers
    private double[][] usage; // power usage this month (per day and per hour)
    private double[][] prices; // power prices for this month
    private double amount; // total price for this month

    // 🔹 Konstruktør
    public Invoice(Customer c, String month, double[][] usage, double[][] power_prices) {
        this.c = c;
        this.month = month;
        this.usage = usage;
        this.prices = power_prices;
        this.amount = 0;
    }

    // 🔹 Beregner totalbeløp
    public void computeAmount() {
        double total = 0.0;

        // summer forbruk × pris
        for (int i = 0; i < usage.length; i++) {
            for (int j = 0; j < usage[i].length; j++) {
                total += usage[i][j] * prices[i][j];
            }
        }

        // hent avtaletype (enum)
        PowerAgreementType avtale = c.getAgreement();

        // beregner basert på avtaletype
        if (avtale == PowerAgreementType.SPOTPRICE) {
            this.amount = total;
        } else if (avtale == PowerAgreementType.POWERSUPPORT) {
            this.amount = total * 1.10; // f.eks. 10 % påslag
        } else if (avtale == PowerAgreementType.NORGESPRICE) {
            this.amount = total * 1.05; // f.eks. 5 % påslag
        } else if (avtale == PowerAgreementType.LAVESTPRIS) {
            this.amount = total * 0.90; // f.eks. 10 % rabatt
        } else {
            this.amount = total;
        }
    }

    // 🔹 Skriver ut faktura
    public void printInvoice() {
        System.out.println("=========================================");
        System.out.println("           REGNBYEN BERGEN AS");
        System.out.println("           MÅNEDLIG STRØMFAKTURA");
        System.out.println("=========================================");
        System.out.println("Kunde:     " + c.getName());
        System.out.println("Avtale:    " + c.getAgreement());
        System.out.println("Måned:     " + month);
        System.out.println("-----------------------------------------");
        System.out.println(String.format("Totalbeløp: %.2f kr", amount));
        System.out.println("=========================================\n");
    }

    //  Metode som kan behandle og skrive ut flere fakturaer
    public static void processInvoices(Invoice[] invoices) {
        for (int i = 0; i < invoices.length; i++) {
            invoices[i].computeAmount();
            invoices[i].printInvoice();
        }
    }
}


