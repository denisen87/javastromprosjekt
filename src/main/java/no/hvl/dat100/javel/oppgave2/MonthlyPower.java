package no.hvl.dat100.javel.oppgave2;
import no.hvl.dat100.javel.oppgave1.DailyPower;

// a) Skrive ut månedlig strømforbruk
public class MonthlyPower {

    public static void printPowerUsage(double[][] poweruse) {
        for (double[] row : poweruse) {
            for (double value : row) {
                System.out.print(value + " kWh ");
            }
            System.out.println();
        }
    }

    // b) Skrive ut månedlige strømpriser
    public static void printPowerPrices(double[][] prices) {
        for (double[] row : prices) {
            for (double value : row) {
                System.out.print(value + " kr ");
            }
            System.out.println();
        }
    }

    // c) Total månedlig forbruk
    public static double computePowerUsage(double[][] usage) {
        double sum = 0;
        for (double[] row : usage) {
            for (double value : row) {
                sum += value;
            }
        }
        return sum;
    }

    // d) Forbruksgrense
    public static boolean exceedThreshold(double[][] powerusage, double threshold) {
        double sum = 0; // threshold er parameter vi måler summen av månedlig forbruk mot,
        int i = 0; // threshold får en verdi når vi kjører metoden exceedThreshold
        boolean exceeded = false; // lager påstanden exceeded(overskredet) og sitter denne-
// til å være feil, som betyr ikke overskredet, summen av månedlig forbruk er alle verdiene til
// powerusage lagt sammen i while løkken
        while (i < powerusage.length && !exceeded) { // kjører løkken helt til alle plassene i -
            // tabellen er telt med og ikke exceeded som betyr ikke overskredet eller exceeded lik-,
            int j = 0; // false
            while (j < powerusage[i].length && !exceeded) {
                sum += powerusage[i][j]; // setter summen er lik verdien til j i rad i i tabellen -
                //  + den forrige summen
                if (sum > threshold) { // vist sum er større enn overskredet verdi endres betydningen -
                    exceeded = true; // av exceeded til sant, dette innebærer løkken stopper da -
                } // påstanden exceeded er sann og betingelsen for at løkken skal kjøre ikke er -
                j++; // oppfylt lengre, legger til både i og j så lenge løkken kjører
            }
            i++;
        }

        if (exceeded) { // vist summen av alle forbrukene er overskredet print forbruket overstiger
            // grensen + det totale forbruket
            System.out.println("Forbruket overstiger grensen! (" + sum + " kWh)");
        } else { // eller print forbruk er innenfor + det totale forbruket
            System.out.println("Forbruket er innenfor grensen. (" + sum + " kWh)");
        }

        return exceeded; // returnerer overskredet verdi vist summen av forbruker overstiger grensen
    }

    // e) Spotpris for måneden
    public static double computeSpotPrice(double[][] usage, double[][] prices) {
        double total = 0; // i og j er begge knyttet(peker) opp til begge tabellene usage og -
        // prices, noe som at løkken går gjennom begge tabellene for plassene og radene j og i,
        for (int i = 0; i < usage.length; i++) { // kjører løkke som går gjennom radene
            for (int j = 0; j < usage[i].length; j++) { // kjører løkke som går gjennom plassene
                total += usage[i][j] * prices[i][j]; // ganger verdi til plass j i rad i til
                // tabellen usage med plassen j i rad i til tabellen prices
            }
        }
        return total;
    }

    // f) power support for the month
    public static double computePowerSupport(double[][] usage, double[][] prices) {

        double support = 0;
        for (int i = 0; i < usage.length; i++) {
            for (int j = 0; j < usage[i].length; j++) {
                support += DailyPower.getSupport(usage[i][j], prices[i][j]); // 👈 kaller metoden
            } // plass og rad indeksene som i oppgave e blir begge knyttet til parameterne usage-
        } // og prices, som betyr at for løkken kjører gjennom begge tabellene usage og prices -
        return support; // og henter ut plass verdiene, bruker så metoden get.support fra oppgave-
    }// 1 til å printe ut støtten som blir gitt hver enkelt time,

    // g) Norgesprice for the month
    public static double computeNorgesPrice(double[][] usage) {

        double price = 0;
        double pris = 0.5;
        for (int i = 0; i < usage.length; i++){
            for(int j = 0; j < usage[i].length; j++ ){
                price = price + usage[i][j]*pris;
            }
        }
        return price;
    }
}








