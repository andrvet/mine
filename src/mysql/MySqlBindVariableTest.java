package mysql;

/*****************************************************************/
/* Copyright 2013 Code Strategies                                */
/* This code may be freely used and distributed in any project.  */
/* However, please do not remove this credit if you publish this */
/* code in paper or electronic form, such as on a web site.      */
/*****************************************************************/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlBindVariableTest {
	public static void main(String[] args) {
		java.sql.Connection conn = null;
		java.sql.PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//String connectionUrl = "jdbc:mysql://localhost:3306/testdatabase";
			String connectionUrl = "jdbc:mysql://testpub.arabidopsis.org:3306/pub";
			String connectionUser = "pubuser";
			String connectionPassword = "bengt";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			//String sqlStmt = "SELECT * FROM employees where last_name=? and first_name like ?";
			String sqlStmt = "select id, pub_phenotype_id, pub_germplasm_id  "
					+ " from  pub_germplasm_phenotype "
					+ " where  pub_phenotype_id=? ";
					//+ "and pub_germplasm_id = ?  limit 1"; 
					
			System.out.println("SQL Statement:\n\t" + sqlStmt);
			prepStmt = conn.prepareStatement(sqlStmt);
			System.out.println("Prepared Statement before bind variables set:\n\t" + prepStmt.toString());
			prepStmt.setString(1, "16731");
			//prepStmt.setString(2, "353710");
			System.out.println("Prepared Statement after bind variables set:\n\t" + prepStmt.toString());
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pub_phenotype_id = rs.getString("pub_phenotype_id");
				String pub_germplasm_id = rs.getString("pub_germplasm_id");
				System.out.println("ID: " + id + 
						", pub_phenotype_id: " + pub_phenotype_id + 
						", pub_germplasm_id: " + pub_germplasm_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (prepStmt != null)
					prepStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}