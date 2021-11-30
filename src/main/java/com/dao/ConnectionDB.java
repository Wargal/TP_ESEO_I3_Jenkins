package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {
	
    private static final Logger LOGGER = Logger.getLogger(ConnectionDB.class.getName());

	private ConnectionDB() {

	}

	/**
	 * URL de connexion
	 */
	 private static String url =
	 "jdbc:mysql://192.168.56.109/maven?autoReconnect=true";

	/**
	 * Nom du user
	 */
	private static String user = "api-consumer";
	/**
	 * Password du user
	 */
	// private static String password = "";
	private static String password = "api-password";

	/**
	 * Objet Connexion
	 */
	private static Connection connect;

	/**
	 * @return
	 */
	public static Connection getInstance() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
            LOGGER.log(Level.SEVERE, "Exception occur", e1);

		}
		if (connect == null) {
			try {
				connect = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
	            LOGGER.log(Level.SEVERE, "Exception occur", e);
			}
		}
		return connect;
	}
}
