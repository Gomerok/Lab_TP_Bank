package com.mycompany.util;

import com.mycompany.domain.impl.ExchangeRates;

public class CurrencyConverter {
    public static final CurrencyConverter CURRENCY_CONVERTER = new CurrencyConverter();

    private CurrencyConverter() {
    }

//    private static double BYN_BUY_VOLUME= 0.0;
//    private static double USD_BUY_VOLUME= 0.0;
//    private static double EUR_BUY_VOLUME=0.0;
//    private static double RUB_BUY_VOLUME=0.0;

    public static double BYN_SELL_VOLUME = 0.0;
    public static double USD_SELL_VOLUME = 0.0;
    public static double EUR_SELL_VOLUME = 0.0;
    public static double RUB_SEll_VOLUME = 0.0;

    // Bel
    public Double convertFromBynToUsd(String sum) {
        BYN_SELL_VOLUME += Double.valueOf(sum);
        Double transferSum = Double.valueOf(sum) / ExchangeRates.getInstance().getUsdBuy();
        return transferSum;
    }

    public Double convertFromBynToEuro(String sum) {
        BYN_SELL_VOLUME += Double.valueOf(sum);
        Double TransferSum = Double.valueOf(sum) / ExchangeRates.getInstance().getEurBuy();
        return TransferSum;
    }

    public Double convertFromBynToRub(String sum) {
        BYN_SELL_VOLUME += Double.valueOf(sum);
        Double TransferSum = Double.valueOf(sum) / ExchangeRates.getInstance().getRubBuy() * 100;
        return TransferSum;
    }

    //Usd
    public Double convertFromUsdToByn(String sum) {
        USD_SELL_VOLUME += Double.valueOf(sum);
        Double TransferSum = Double.valueOf(sum) * ExchangeRates.getInstance().getUsdSell();
        return TransferSum;
    }

    public Double convertFromUsdToEuro(String sum) {
        USD_SELL_VOLUME += Double.valueOf(sum);
        Double TransferSum = Double.valueOf(sum) * ExchangeRates.getInstance().getUsdSell()
                / ExchangeRates.getInstance().getEurBuy();
        return TransferSum;
    }

    public Double convertFromUsdToRub(String sum) {
        USD_SELL_VOLUME += Double.valueOf(sum);
        Double TransferSum = Double.valueOf(sum) * ExchangeRates.getInstance().getUsdSell()
                / ExchangeRates.getInstance().getRubBuy() * 100;
        return TransferSum;
    }

    //Euro
    public Double convertFromEuroToByn(String sum) {
        EUR_SELL_VOLUME += Double.valueOf(sum);
        Double TransferSum = Double.valueOf(sum) * ExchangeRates.getInstance().getEurSell();
        return TransferSum;
    }

    public Double convertFromEuroToUsd(String sum) {
        EUR_SELL_VOLUME += Double.valueOf(sum);
        Double TransferSum = Double.valueOf(sum) * ExchangeRates.getInstance().getEurSell()
                / ExchangeRates.getInstance().getUsdBuy();
        return TransferSum;
    }

    public Double convertFromEuroToRub(String sum) {
        EUR_SELL_VOLUME += Double.valueOf(sum);
        Double TransferSum = Double.valueOf(sum) * ExchangeRates.getInstance().getEurSell()
                / ExchangeRates.getInstance().getRubBuy() * 100;
        return TransferSum;
    }

    //Rub
    public Double convertFromRubToByn(String sum) {
        RUB_SEll_VOLUME += Double.valueOf(sum);
        Double TransferSum = Double.valueOf(sum) * ExchangeRates.getInstance().getRubSell() / 100;
        return TransferSum;
    }

    public Double convertFromRubToEuro(String sum) {
        RUB_SEll_VOLUME += Double.valueOf(sum);
        Double TransferSum = Double.valueOf(sum) * ExchangeRates.getInstance().getRubSell()
                / ExchangeRates.getInstance().getEurBuy() / 100;
        return TransferSum;
    }

    public Double convertFromRubToUsd(String sum) {
        RUB_SEll_VOLUME += Double.valueOf(sum);
        Double TransferSum = Double.valueOf(sum) * ExchangeRates.getInstance().getRubSell()
                / ExchangeRates.getInstance().getUsdBuy() / 100;
        return TransferSum;
    }

}
