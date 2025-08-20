# Currency-Converter
🌍 Currency Converter (Java)

A simple Java-based Currency Converter that uses the ExchangeRate-API to fetch real-time currency exchange rates.
This program allows users to convert an amount from one currency to another directly from the console.

🚀 Features

Fetches live exchange rates using API.

Supports any currency code (e.g., USD, EUR, INR, JPY, etc.).

Simple command-line interface for user input.

Handles invalid inputs and API errors gracefully.


🛠 Technologies Used

Java (Core Java, Networking, I/O)

ExchangeRate API (for real-time exchange rates)


📌 How It Works

1. User enters:

Base currency (e.g., USD)

Target currency (e.g., INR)

Amount to convert

2. Program sends a request to the ExchangeRate API.

3. The API returns the latest exchange rate.

4. The converted value is displayed to the user.


🖥 Example Usage

🌍 Currency Converter

Enter base currency (e.g., USD): USD

Enter target currency (e.g., INR): INR

Enter amount to convert: 100

💱 100.0 USD = 8707.11 INR

⚡ Setup Instructions

1. Navigate into the project folder: cd CurrencyConverter

2. Compile the Java program: javac CurrencyConverter.java

3. Run the program: java CurrencyConverter

🔑 API Key

This project uses the ExchangeRate-API.

The API_KEY value in CurrencyConverter.java with your own key:

static final String API_KEY = "0a0b669b90461beb3f86a932";
