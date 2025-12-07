package com.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class Currencies implements Currency {

    private final String nameOfCurrency;
    private final double rateOfCurrency;

    private static final Map<String, Double> currencyRates = new HashMap<>();

    static {
        currencyRates.put("bhd", 1.0);
        currencyRates.put("usd", 3.76);
        currencyRates.put("eur", 4.02);
        currencyRates.put("gbp", 4.64);
        currencyRates.put("sar", 0.10);
        currencyRates.put("pkr", 743.82);
    }


    public Currencies(String nameOfCurrency, double rateOfCurrency) {
        this.nameOfCurrency = nameOfCurrency;
        this.rateOfCurrency = rateOfCurrency;
    }

    @Override
    public String getNameOfCurreny() {
        return nameOfCurrency;
    }

    @Override
    public double getConversionRate() {
        return rateOfCurrency;
    }

    public static Optional<Double> convert(double amount, String from, String to) {

        Optional<Double> fromRate = currencyRates.entrySet().stream()
                .filter(e -> e.getKey().equalsIgnoreCase(from))
                .map(Map.Entry::getValue)
                .findFirst();

        Optional<Double> toRate = currencyRates.entrySet().stream()
                .filter(e -> e.getKey().equalsIgnoreCase(to))
                .map(Map.Entry::getValue)
                .findFirst();

        if (fromRate.isEmpty() || toRate.isEmpty()) {
            return Optional.empty();
        }

        double result = amount * (toRate.get() / fromRate.get());
        return Optional.of(result);
    }
    public static void listCurrencies() {
        currencyRates.keySet()
                .forEach(System.out::println);
    }
    public static void listCurrencyPrices() {
        currencyRates.forEach((key, value) ->
                System.out.println(key.toUpperCase() + " : " + value)
        );
    }

}
