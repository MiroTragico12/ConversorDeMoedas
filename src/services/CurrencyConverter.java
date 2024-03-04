package services;

import java.security.InvalidParameterException;

public interface CurrencyConverter {

    default double convertToRealWithDefault(double amount, double exchangeRate) {
        if (amount < 1) {
            throw new InvalidParameterException("A quantia convertida tem que ser maior que 0 !");
        }
        return amount * exchangeRate;
    }

    double ConverterToReal(double amount);
}
