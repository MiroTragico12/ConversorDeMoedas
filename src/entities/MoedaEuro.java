package entities;

import services.CurrencyConverter;

public class MoedaEuro implements CurrencyConverter {
    
    private double euroRate;
    
    public MoedaEuro(double euroRate) {
        this.euroRate = euroRate;
    }

    @Override
    public double ConverterToReal(double amount) {
        return convertToRealWithDefault(5.37, euroRate);
    }

}
