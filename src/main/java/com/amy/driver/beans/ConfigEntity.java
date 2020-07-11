package com.amy.driver.beans;

public class ConfigEntity {
    private ChromeConfig chrome;
    private GeckoConfig firefox;

    public ChromeConfig getChrome() {
        return chrome;
    }

    public void setChrome(ChromeConfig chrome) {
        this.chrome = chrome;
    }

    public GeckoConfig getFirefox() {
        return firefox;
    }

    public void setFirefox(GeckoConfig firefox) {
        this.firefox = firefox;
    }

    @Override
    public String toString() {
        return "ConfigEntity{" +
                "chrome=" + chrome +
                ", firefox=" + firefox +
                '}';
    }
}
