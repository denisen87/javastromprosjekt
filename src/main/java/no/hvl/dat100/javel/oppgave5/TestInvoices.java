package no.hvl.dat100.javel.oppgave5;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;
import no.hvl.dat100.javel.oppgave2.MonthlyPower;
import no.hvl.dat100.javel.oppgave3.Customer;

public class TestInvoices {

    public static void main(String[] args) {
        System.out.println("Tester fakturaer...");

        // Oppretter kunder
        Customer kunde1 = new Customer("Alice", "Bergen", 1001, PowerAgreementType.SPOTPRICE);
        Customer kunde2 = new Customer("Åge Kleppe", "Os", 1002, PowerAgreementType.POWERSUPPORT);
        Customer kunde3 = new Customer("Linda Hjelde", "Fana", 1003, PowerAgreementType.LAVESTPRIS);
        Customer kunde4 = new Customer("Jan Hansen", "Fana", 1004, PowerAgreementType.LAVESTPRIS);
        Customer kunde5 = new Customer("Bjørn Vidar", "Fana", 1005, PowerAgreementType.SPOTPRICE);
        Customer kunde6 = new Customer("Kristin Johannesen", "Fana", 1006, PowerAgreementType.SPOTPRICE);

        // Bruk ferdige data fra CustomerPowerUsageData
        double[][] usage1 = CustomerPowerUsageData.usage_month_customer1;
        double[][] usage2 = CustomerPowerUsageData.usage_month_customer2;
        double[][] usage3 = CustomerPowerUsageData.usage_month_customer3;
        double[][] usage4 = CustomerPowerUsageData.usage_month_customer3;
        double[][] usage5 = CustomerPowerUsageData.usage_month_customer1;
        double[][] usage6 = CustomerPowerUsageData.usage_month_customer2;


        // Midlertidig prisdata (bruker forbrukstabell som test)
        double[][] prices = CustomerPowerUsageData.usage_month_customer1;

        // Lager fakturaobjekter for kundene
        Invoice faktura1 = new Invoice(kunde1, "Oktober", usage1, prices);
        Invoice faktura2 = new Invoice(kunde2, "Oktober", usage2, prices);
        Invoice faktura3 = new Invoice(kunde3, "Oktober", usage3, prices);
        Invoice faktura4 = new Invoice(kunde4, "Oktober", usage4, prices);
        Invoice faktura5 = new Invoice(kunde5, "Oktober", usage5, prices);
        Invoice faktura6 = new Invoice(kunde6, "Oktober", usage6, prices);

        // Samler fakturaene i et array
        Invoice[] fakturaListe = { faktura1, faktura2, faktura3,faktura4, faktura5, faktura6 };

        // Behandler og skriver ut alle fakturaer
        Invoice.processInvoices(fakturaListe); // Invoice er klassen og processInvoices er metoden -
    } // Invoice klassen,
}

