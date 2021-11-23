package com.dao;

import java.util.ArrayList;

public class SQLSelectForger {

	// SELECT <Table>.<column> AS <name>, ... FROM
	private ArrayList<ArrayList<String>> selected;
	private ArrayList<ArrayList<String>> whereValueClauses;

	private String sourceTable;
	private int limit, offset;

	SQLSelectForger(String sourceTable) {
		selected = new ArrayList<ArrayList<String>>();
		whereValueClauses = new ArrayList<ArrayList<String>>();

		this.sourceTable = sourceTable;
		this.limit = -1;
		this.offset = -1;
	}

	public void addSelectionColumn(String table, String column, String alias) {
		ArrayList<String> element = new ArrayList<String>();
		element.add(table);
		element.add(column);
		element.add(alias);
		selected.add(element);
	}

	public void addValueWhereClause(String table, String column, String value) {
		ArrayList<String> element = new ArrayList<String>();
		element.add(table);
		element.add(column);
		element.add(value);
		whereValueClauses.add(element);
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public String toString() {
		String out = "SELECT ";
		if (selected.size() == 0) {
			out += '*';
		} else {
			for (int i = 0; i < selected.size(); i++) {
				ArrayList<String> arrayList = selected.get(i);
				out += arrayList.get(0);
				out += '.';
				out += arrayList.get(1);
				if (arrayList.size() == 3) {
					out += " AS ";
					out += arrayList.get(2);
				}
				if (i < selected.size() - 1) {
					out += ", ";
				}
			}
		}
		out += " FROM ";
		out += this.sourceTable;

		for (int i = 0; i < whereValueClauses.size(); i++) {
			ArrayList<String> arrayList = whereValueClauses.get(i);
			if(i==0) {
			out += " WHERE ";
			}
			out += arrayList.get(0);
			out += '.';
			out += arrayList.get(1);
			out += " = ";
			out +="\"";
			out += arrayList.get(2);
			out +="\"";

			if (i < whereValueClauses.size() - 1) {
				out += " AND ";
			}
		}

		if (this.limit >= 0) {
			out += " LIMIT ";
			out += this.limit;
		}
		if (this.offset >= 0) {
			out += " OFFSET ";
			out += this.offset;
		}
		System.out.println("Query : "+out);
		return out;
	}
}
