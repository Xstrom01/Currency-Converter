import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    static final String API_KEY = "0a0b669b90461beb3f86a932";
    static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🌍 Currency Converter");

        System.out.print("Enter base currency (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter target currency (e.g., INR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        try {
            double rate = fetchExchangeRate(baseCurrency, targetCurrency);
            if (rate != -1) {
                double converted = amount * rate;
                System.out.printf("💱 %.2f %s = %.2f %s\n", amount, baseCurrency, converted, targetCurrency);
            } else {
                System.out.println("❌ Unable to fetch exchange rate.");
            }
        } catch (Exception e) {
            System.out.println("⚠ Error: " + e.getMessage());
        }

        scanner.close();
    }

    public static double fetchExchangeRate(String base, String target) throws Exception {
        String urlStr = API_URL + base;  // e.g., https://v6.exchangerate-api.com/v6/API_KEY/latest/USD

        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        if (status != 200) {
            throw new RuntimeException("HTTP Error Code: " + status);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String input;

        while ((input = in.readLine()) != null) {
            response.append(input);
        }
        in.close();
        // Manually parse the exchange rate from JSON (no external libraries)
        String json = response.toString();
        String find = "\"" + target + "\":";
        int index = json.indexOf(find);

        if (index == -1) return -1;

        int start = index + find.length();
        int end = json.indexOf(",", start);
        if (end == -1) end = json.indexOf("}", start); // in case it's the last element

        String rateStr = json.substring(start, end).trim();
        return Double.parseDouble(rateStr);
    }
}