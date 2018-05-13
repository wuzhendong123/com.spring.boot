package com.spring.boot.config.optimist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import se.spagettikod.optimist.LockedByAnotherUserException;
import se.spagettikod.optimist.impl.EntityWrapper;
import se.spagettikod.optimist.impl.Mapper;

public class OracleMapper extends Mapper {

	@Override
	public Object getCurrentEntityVersionInDatabase(Connection connection,
			EntityWrapper entityWrapper) throws SQLException {
		PreparedStatement stmt = null;
//		try {
//			entityWrapper.
//			stmt = connection
//					.prepareStatement("SELECT "
//							+ entityWrapper.getVersionColumnName() + " FROM "
//							+ entityWrapper.getTableName()
//							+ " WHERE ID = ? ");
//			stmt.setObject(1, entityWrapper.getIdentity());
//			stmt.execute();
//			ResultSet rs = stmt.getResultSet();
//			if (rs.next()) {
//				Object databaseVersion = rs.getInt(1);
//				rs.close();
//				return databaseVersion;
//			} else {
//				return null;
//			}
//		} catch (SQLException e) {
//			throw new LockedByAnotherUserException();
//		} finally {
//			if (stmt != null) {
//				stmt.close();
//			}
//		}
		return stmt;
	
	}

}
