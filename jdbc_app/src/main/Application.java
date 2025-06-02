package main;

import connection.ConnectionUtil_HikariCP;
import ui_handler.MainUIHandler;

public class Application {
    public static void main(String[] args)
    {
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "WARN");

        System.out.println("# RUNNING APP");

        MainUIHandler mainUIHandler = new MainUIHandler();
        try {
            mainUIHandler.handle();
            ConnectionUtil_HikariCP.closeDataSource();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            ConnectionUtil_HikariCP.closeDataSource();
        }
    }
}