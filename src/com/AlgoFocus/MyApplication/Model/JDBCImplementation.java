package com.AlgoFocus.MyApplication.Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;



public class JDBCImplementation implements AppDAO {

	Connection con = null;
	PreparedStatement pstmt = null;

	public boolean firstAppInsert(String fname, String mname,String password) {
		
	

		try {
			// 1. Load the Driver

			Class.forName("com.mysql.jdbc.Driver");

			// 2.Get the DB Connection via Driver

			String url = "jdbc:mysql://localhost:3306/MyApp";
			
			FileReader reader = new FileReader("E:\\My Workspace\\SampleWebApp\\WebContent\\credenti.properties");
			Properties prop = new Properties();
			prop.load(reader);

			con=DriverManager.getConnection(url, prop);

			// 3. Issue Sql Queries via Connection

			String query = " insert into MyApp values(?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, fname);
			pstmt.setString(2, mname);
			pstmt.setString(3, password);
			
			int count = pstmt.executeUpdate();

			// 4. process the result
			if (count == 1) 
			{

				//System.out.println("Successfully entered Candidate Details");
				return true;
			} else {
				System.out.println("Please retry");
				return false;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {

			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}


