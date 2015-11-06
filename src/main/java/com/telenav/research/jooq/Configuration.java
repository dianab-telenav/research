package com.telenav.research.jooq;

import java.io.IOException;
import java.util.Properties;


/**
 *
 *
 * @author dianabalan
 */
public enum Configuration {

    INSTANCE;

    private String url = "";
    private String password = "";
    private String user = "";

    private Configuration() {

        final Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("dbconfig.properties"));
            url = properties.getProperty(DbProperties.URL);
            password = properties.getProperty(DbProperties.PASSWORD);
            user = properties.getProperty(DbProperties.USER);
        } catch (final IOException e) {
            throw new ExceptionInInitializerError();
        }

    }


    public String getPassword() {
        return password;
    }


    public String getUrl() {
        return url;
    }


    public String getUser() {
        return user;
    }


}
