package no.hvl.dat100.javel.oppgave1;

import no.hvl.dat100.javel.oppgave2.MonthlyPower;

public class DayMain {

    public static void main(String[] args) {
        double[] prices = DayPowerData.powerprices_day; // putter inn verdiene i -
        // tabellen inn variabelen prices
        DailyPower.printPowerPrices(prices); // referer til klassen DayliPower hvor
        // metoden printPowerPrices ligger, kjører så metoden printPowerPrices som
        // henter ut verdiene fra variabelen prices
        System.out.println();
        double [] poweruse = DayPowerData.powerusage_day;
        DailyPower.printPowerUsage(poweruse);
        double totalusage = DailyPower.computePowerUsage(poweruse); // putter verdien
        // som metoden computePowerUsage(poweruse) lager inn variabelen totalusage,
        // metoden computePowerUsage(poweruse) lager den sammenlagte verdien av all
        // strømforbruket som er i powerusage_day, men printer den ikke ut,
        System.out.printf("%nTotalt strømforbruk for dagen: %.2f kWh%n", totalusage);
        // det gjør metoden System.out.print
        double dagspris = DailyPower.computeSpotPrice(DayPowerData.powerusage_day,DayPowerData.powerprices_day);
        // metoden computeSpotPrice går ned tabellene powerusage_day og powerprices_day og henter tabellverdiene,
        // regner om slik at vi får dagsprisen på strømmen, putter denne i variabelen dagspris, skriver ut med println.
        System.out.println("Prisen for strøm hele dagen er: " + dagspris + " kr");
        double usage = 2.0;      // kWh
        double price = 1.20;
        double support1 = DailyPower.getSupport(2,1.2);
        System.out.printf("Støtte ved pris %.2f kr", price, support1);
        double sumstotte = DailyPower.computePowerSupport(DayPowerData.powerusage_day,DayPowerData.powerprices_day);
        System.out.printf("Total støtte for dagen: %.4f kr%n", sumstotte);
        double prisstrom = DailyPower.computeNorgesPrice(DayPowerData.powerusage_day);
        System.out.printf("Pris med Norgespris (0.50 kr/kWh): %.2f kr%n", prisstrom);
        double storsteforbruk = DailyPower.findPeakUsage(DayPowerData.powerusage_day);
        System.out.printf("Største forbruk i løpet av dagen: %.2f kWh%n", storsteforbruk);
        double gjennomsnittforbruk = DailyPower.findAvgPower(DayPowerData.powerusage_day);
        System.out.printf(" gjennomsnittlig strømforbruk i løpet av dagen er : %.2f ", + gjennomsnittforbruk);






         //
         //Write code that tests the methods you implement in the DailyPower class
         //Remember to teste the methods as you implement them
         // Remember to also to check that you get the expected results


    }
}
