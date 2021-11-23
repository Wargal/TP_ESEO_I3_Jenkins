package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	// private static Logger logger = Logger.getLogger("logger");

	private ConnectionDB() {

	}

	/**
	 * URL de connexion
	 */
	// private static String url =
	// "jdbc:mariadb://localhost:3306/MoniCrop?autoReconnect=true";
	//private static String url = "jdbc:mariadb://172.24.6.14/MoniCrop?autoReconnect=true";
	 private static String url =
	 "jdbc:mysql://192.168.56.109/maven?autoReconnect=true";

	/**
	 * Nom du user
	 */
	// private static String user = "root";
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
			System.out.println("Issue BDD Driver");
			//logger.log(Level.INFO, "Issue Driver BDD");
		}
		if (connect == null) {
			try {
				connect = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// LoggerSystem log = new LoggerSystem(LOGGER_NAME);
				// log.addLog(e.getMessage(), "info");
				e.printStackTrace();
			}
		}
		return connect;
	}
}
