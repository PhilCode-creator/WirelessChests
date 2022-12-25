package de.philipp.wirelesschest.util;

import org.bukkit.Bukkit;

import java.sql.*;

public class MySQL {

    private Connection connection;

    public void connect(String host, String user, String pw, String port, String database) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pw);
            Bukkit.getConsoleSender().sendMessage("[WirelessChests] Datenbank verbunden!");
            statement("CREATE IF NOT EXISTS TABLE `links` (`ID` INT NOT NULL AUTO_INCREMENT , `NAME` VARCHAR(255) NOT NULL , `FROMX` DOUBLE(255) NOT NULL , `FROMY` INT(255) NOT NULL , `FROMZ` INT(255) NOT NULL , `TOX` INT(255) NOT NULL , `TOY` INT(255) NOT NULL , `TOZ` INT(255) NOT NULL , `OWNER` INT(36) NOT NULL , `CREATED` INT(255) NOT NULL , PRIMARY KEY (`ID`))");
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("[WirelessChests] Fehler beim verbinden mit der Datenbank:" + e);
        }
    }

    public void disconnect() {
        connection = null;
        Bukkit.getConsoleSender().sendMessage("[WirelessChests] Datenbank getrennt!");
    }

    public ResultSet getResult(String sql) {
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //

    public void statement(String sql) {
        try {
            Statement stmt=connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}