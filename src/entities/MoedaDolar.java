package entities;

import services.CurrencyConverter;

public class MoedaDolar implements CurrencyConverter {
    
    private double dolarRate;
    
    public MoedaDolar(double dolarRate) {
        this.dolarRate = dolarRate;
    }

    @Override
    public double ConverterToReal(double amount) {
        return convertToRealWithDefault(amount = 4.95, dolarRate);
    }

}
