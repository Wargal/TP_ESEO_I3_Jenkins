package com.dao;

import java.sql.Connection;
import java.util.List;

public abstract class Dao<T> {
	public final Connection connect = ConnectionDB.getInstance();
	

}
