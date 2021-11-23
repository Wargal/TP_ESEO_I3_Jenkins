package com.dao;

import java.util.ArrayList;

public class SQLDeleteForger {

	
	private ArrayList<String> condition;

	private String sourceTable;

	SQLDeleteForger(String sourceTable) {
		this.sourceTable = sourceTable;
	}


	public void setCondition(String column, String value) {
		condition = new ArrayList<String>();
		condition.add(column);
		condition.add(value);
	}

	@Override
	public String toString() {
		String out = "DELETE FROM ";
		out += sourceTable;
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
