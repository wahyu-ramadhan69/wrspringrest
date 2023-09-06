package com.example.bcaf.wrspringrest.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:other.properties")
public class OtherConfiguration {
    private static String flagLoging;
    private static String flagLogTable;

    public static String getFlagLogTable() {
        return flagLogTable;
    }

    @Value("${flag.logTable}")
    private void setFlagLogTable(String flagLogTable) {
        OtherConfiguration.flagLogTable = flagLogTable;
    }

    public static String getFlagLoging() {
        return flagLoging;
    }

    @Value("${flag.loging}")
    private void setFlagLoging(String flagLoging) {
        OtherConfiguration.flagLoging = flagLoging;
    }
}
