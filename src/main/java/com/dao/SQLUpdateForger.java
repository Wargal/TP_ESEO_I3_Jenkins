package com.dao;

import java.util.ArrayList;

public class SQLUpdateForger {

	// INSERT INTO table (<column>, ...VALUES ('<value>', ...)
	private ArrayList<ArrayList<String>> updated;
	private ArrayList<String> condition;

	private String sourceTable;

	SQLUpdateForger(String sourceTable) {
		updated = new ArrayList<ArrayList<String>>();

		this.sourceTable = sourceTable;
	}

	public void addUpdatedValue(String column, String value) {
		ArrayList<String> element = new ArrayList<String>();
		element.add(column);
		element.add(value);
		updated.add(element);
	}
	
	public void setCondition(String column, String value) {
		condition = new ArrayList<String>();
		condition.add(column);
		condition.add(value);
	}

	@Override
	public String toString() {
		String out = "UPDATE ";
		out += sourceTable;
		out += " SET ";
		for (int i = 0; i < updated.size(); i++) {
			ArrayList<String> arrayList = updated.get(i);

			out+=arrayList.get(0);
			out+= " = ";
					out+=arrayList.get(1);
			if (i < updated.size() - 1) {
				out += ", ";
			}
		}
		if(condition.size()==2) {
			out+= " WHERE ";
			out+=condition.get(0);
			out+=" = ";
			out+=condition.get(1);

			
		} else {
			out = "";
		}
		System.out.println("Query : " + out);
		return out;
	}
}
