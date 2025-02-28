import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, This is the International Gold Price to Myanmar Gold Price Conversion System!");

        System.out.println("Please enter gold price per pound in USD number");
        double dblGoldPricePerPoundInUSD = scanner.nextDouble();


        System.out.println("Please enter 1 USD price in MMK number");
        double dblOneUSDPriceInMMK = scanner.nextDouble();


        calculateTheMMKGoldPricePerKyatThar(
                dblGoldPricePerPoundInUSD,
                dblOneUSDPriceInMMK
        );


    }

    private static void calculateTheMMKGoldPricePerKyatThar(
            double dblGoldPricePerPoundInUSD,
            double dblOneUSDPriceInMMK
    ){
        double ouncePerViss = 57.6;
        double pricePerViss = ouncePerViss * dblGoldPricePerPoundInUSD;
        double pricePerKyatTharInUSD = pricePerViss / 100;

        double pricePerKyatTharInMMK = pricePerKyatTharInUSD * dblOneUSDPriceInMMK;

        System.out.println("Gold MMK price per kyat thar : " + Double.toString(pricePerKyatTharInMMK));
    }
}