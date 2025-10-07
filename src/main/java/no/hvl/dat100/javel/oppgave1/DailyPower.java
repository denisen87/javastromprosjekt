package no.hvl.dat100.javel.oppgave1;

public class DailyPower {

    // a) print power prices during a day
    public static void printPowerPrices(double[] prices) {
        for(int i = 0; i < prices.length; i++) {
            System.out.print(prices[i] + " kr ");

         }

    }

    // b) print power usage during a day
    public static void printPowerUsage(double[] poweruse) {
            for(int i = 0; i < poweruse.length; i++) {
                System.out.print(poweruse[i] + " kWh ");
            }

    }

    // c) compute power usage for a single day
    public static double computePowerUsage(double[] usage) {
        double sum = 0;
        for (int i = 0; i < usage.length; i++) {
            sum = sum + usage[i];
        }
        return sum;

    }

    // d) compute spot price for a single day
    public static double computeSpotPrice(double[] usage, double[] prices) {
        double sum = 0;
        for (int i = 0; i < usage.length; i++) {
            sum = sum + prices[i]*usage[i];
        }

        return sum;
    }

    // e) compute power support for a given usage and price
    private static final double THRESHOLD = 0.9375;
    private static final double PERCENTAGE = 0.9;

    public static double getSupport(double usage, double price) {
        double support = 0;
        if (price > 0.9375) {
            support = (price-0.9375) * usage * 0.9;
            System.out.print("støtten er på " + support);
        } else {
            System.out.println(" ingen støtte gis");
        }
        return support;
    }

    // f) compute power support for a single day
    public static double computePowerSupport(double[] usage, double[] prices) {

        double totalsupport = 0;
        for(int i = 0; i < prices.length; i++){
            double price = prices[i];
            double use = usage[i];
            if (price > 0.9375) {
                totalsupport = totalsupport + getSupport(use, price);
            }
            else{
                totalsupport = totalsupport + 0 ;

            }
        }
        return totalsupport;
    }

    private static final double NORGESPRIS_KWH = 0.5;

    // g) compute norges pris for a single day
    public static double computeNorgesPrice(double[] usage) {

        double totalforbruk = 0;
        for (int i = 0; i < usage.length; i++) {
            totalforbruk = usage[i] + totalforbruk; // henter verdien til plassen i og legger den sammen med total-
            // forbruk, i neste sekvens er verdien til totalforbruk den samme verdien usage[i] hadde i forrige sekvens,
            // usage[i] får en ny verdi i neste sekvens, som igjen legges sammen med verdien til totalforbruk

        }

        return totalforbruk * NORGESPRIS_KWH;

    }

    // g) compute peak usage during a single day
    public static double findPeakUsage(double[] usage) {

        double forbruk_max = 0; // max forbruk starter på 0
        for (int i = 0; i < usage.length; i++) { // kjører løkken gjennom alle plassene i tabellen
            double forbruk = usage[i]; // putter verdien i plassen i inn i variabelen forbruk
            if (forbruk > forbruk_max) { // vist forbruk er høyere enn forbruk maks som er 0 i første omgang -
                forbruk_max = forbruk; // så settes forbruks verdil til maks, da det er ingen høyere verdi enn
                // verdien til forbruk,
            }
            else {
                forbruk = forbruk; // ellers vist ikke forbruk > maksforbruk så har vi ikke en ny maks verdi, og
                // setter derfor forbuk lik forbruk som da gjør at den høyeste verdien frem til no står uendret, denne
                // linjer er ikke i bruk, men er ment som et bilde på hva som skjer med forbruk i bakrunnen
            }
        }

        return forbruk_max;

    }


    public static double findAvgPower(double[] usage){

            double sum = 0;
            double antall = 0;
            for(int i = 0; i < usage.length; i++){
                double forbruk = usage[i];
                sum = sum + forbruk;
                antall = antall + 1;

            }
            double gjennomsnitt = sum/antall;

            return gjennomsnitt;
        }
}