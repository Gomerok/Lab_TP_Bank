package com.mycompany.util;

import com.mycompany.domain.impl.ApplicationProperties;
import com.mycompany.domain.impl.ExchangeVolume;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class PropertyReader {
    private static final Properties properties = new Properties();
    private static Logger logger = LoggerFactory.getLogger(PropertyReader.class);

    private PropertyReader() {
    }

    public static void loadProperties() {
        final String propertiesFileName = "src/main/resources/app.properties";

        try (FileInputStream fis = new FileInputStream(propertiesFileName)) {

            properties.load(fis);
        } catch (FileNotFoundException e) {
            logger.error("", e);
        } catch (IOException e) {
            logger.error("", e);
        }
    }

    public static void readProperties() {
        ApplicationProperties.APPLICATION_PROPERTIES.setAdminMenu(properties.getProperty("admin_menu"));
        ApplicationProperties.APPLICATION_PROPERTIES.setChangeExchangeRates(properties.getProperty("change_exchange_rates"));
        ApplicationProperties.APPLICATION_PROPERTIES.setCreateCashier(properties.getProperty("create_cashier"));
        ApplicationProperties.APPLICATION_PROPERTIES.setCrudCashier(properties.getProperty("crud_cashier"));
        ApplicationProperties.APPLICATION_PROPERTIES.setDeleteCashier(properties.getProperty("delete_cashier"));
        ApplicationProperties.APPLICATION_PROPERTIES.setLimitExchangeVolume(properties.getProperty("limit_exchange_volume"));
        ApplicationProperties.APPLICATION_PROPERTIES.setReadCashiers(properties.getProperty("read_cashier"));
        ApplicationProperties.APPLICATION_PROPERTIES.setUpdateCashier(properties.getProperty("update_cashier"));
        ApplicationProperties.APPLICATION_PROPERTIES.setViewOperationHistory(properties.getProperty("view_operation_history"));
        ApplicationProperties.APPLICATION_PROPERTIES.setViewOperations(properties.getProperty("view_operations"));
        ApplicationProperties.APPLICATION_PROPERTIES.setViewMobileOperationHistory(properties.getProperty("view_mobile_operation_history"));

        ApplicationProperties.APPLICATION_PROPERTIES.setBill(properties.getProperty("bill"));
        ApplicationProperties.APPLICATION_PROPERTIES.setCashierMenu(properties.getProperty("cashier_menu"));
        ApplicationProperties.APPLICATION_PROPERTIES.setChooseCurrency(properties.getProperty("choose_currency"));
        ApplicationProperties.APPLICATION_PROPERTIES.setInputClientData(properties.getProperty("input_client_data"));
        ApplicationProperties.APPLICATION_PROPERTIES.setNextStepToPayMobPhone(properties.getProperty("next_step_to_pay_mob_phone"));
        ApplicationProperties.APPLICATION_PROPERTIES.setPayForMobPhone(properties.getProperty("pay_for_mob_phone"));

        ApplicationProperties.APPLICATION_PROPERTIES.setAuth(properties.getProperty("auth"));

        ExchangeVolume.EXCHANGE_VOLUME.setUsdBuyVolume(Double.parseDouble(properties.getProperty("usd_buy_volume")));
        ExchangeVolume.EXCHANGE_VOLUME.setEurBuyVolume(Double.parseDouble(properties.getProperty("eur_buy_volume")));
        ExchangeVolume.EXCHANGE_VOLUME.setRubBuyVolume(Double.parseDouble(properties.getProperty("rub_buy_volume")));
        ExchangeVolume.EXCHANGE_VOLUME.setBynBuyVolume(Double.parseDouble(properties.getProperty("byn_buy_volume")));

        ExchangeVolume.EXCHANGE_VOLUME.setUsdSellVolume(Double.parseDouble(properties.getProperty("usd_sell_volume")));
        ExchangeVolume.EXCHANGE_VOLUME.setEurSellVolume(Double.parseDouble(properties.getProperty("eur_sell_volume")));
        ExchangeVolume.EXCHANGE_VOLUME.setRubSellVolume(Double.parseDouble(properties.getProperty("rub_sell_volume")));
        ExchangeVolume.EXCHANGE_VOLUME.setBynSellVolume(Double.parseDouble(properties.getProperty("byn_sell_volume")));
    }
}
