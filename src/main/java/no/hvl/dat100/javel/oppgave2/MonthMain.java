package no.hvl.dat100.javel.oppgave2;



public class MonthMain {
    public static void main(String[] args) {
        double[][] powerUsageMonth = MonthPowerData.powerusage_month;
        double[][] powerPricesMonth = MonthPowerData.powerprices_month;

        System.out.println("Månedlig strømforbruk:");
        MonthlyPower.printPowerUsage(powerUsageMonth);

        System.out.println("\nMånedlige strømpriser:");
        MonthlyPower.printPowerPrices(powerPricesMonth);

        double totalUsage = MonthlyPower.computePowerUsage(powerUsageMonth);
        System.out.println("\nTotal månedlig forbruk: " + totalUsage + " kWh");

        boolean exceeded = MonthlyPower.exceedThreshold(powerUsageMonth, 1000);
        System.out.println("Overskredet grense: " + exceeded);

        double monedspris = MonthlyPower.computeSpotPrice(powerUsageMonth, powerPricesMonth);
        System.out.println("Totalt månedspris: " + monedspris + " kr");
    }
}
