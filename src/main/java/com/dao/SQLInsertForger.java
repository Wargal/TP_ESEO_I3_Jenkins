package com.dao;

import java.util.ArrayList;

public class SQLInsertForger {

	// INSERT INTO table (<column>, ...VALUES ('<value>', ...)
	private ArrayList<ArrayList<String>> inserted;

	private String sourceTable;

	SQLInsertForger(String sourceTable) {
		inserted = new ArrayList<ArrayList<String>>();

		this.sourceTable = sourceTable;
	}

	public void addInsertionValue(String column, String value) {
		ArrayList<String> element = new ArrayList<String>();
		element.add(column);
		element.add(value);
		inserted.add(element);
	}

	@Override
	public String toString() {
		String out = "INSERT INTO ";
		out += sourceTable;
		String keys = " (";
		String values = " VALUES (";

		for (int i = 0; i < inserted.size(); i++) {
			ArrayList<String> arrayList = inserted.get(i);
			keys+=arrayList.get(0);
			values+=arrayList.get(1);
			if (i < inserted.size() - 1) {
				keys += ", ";
				values += ", ";
			}
		}
		keys += ")";
		values += ")";
		
		out+=keys;
		out+=values;
		System.out.println("Query : " + out);
		return out;
	}
}
