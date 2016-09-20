package com.gwtfiler.server;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwtfiler.client.GreetingService;

@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	String query;

	String url = "jdbc:mysql://localhost:3306/test";

	public void call() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, "root", "");
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String upload(String topic, String stream, String Tag, String plink, String fpath, Boolean checkboxstatus) {
		// TODO Auto-generated method stub
		call();
		String ss = "no";
		int k = 0;
		PreparedStatement pstmt = null;

		try {
			con.setAutoCommit(false);
			File file = new File(fpath);
			pstmt = con.prepareStatement(
					"insert into uploadfile(Topic, Stream, Tag, PublicLink, FileBody, checkboxstatus ) values ( ?, ?, ?, ?, ?, ?)");
			// pstmt.setString(1, id);
			pstmt.setString(1, topic);
			pstmt.setString(2, stream);
			pstmt.setString(3, Tag);
			pstmt.setString(4, plink);
			pstmt.setString(5, file.getAbsolutePath());
			pstmt.setBoolean(6, checkboxstatus);
			k = pstmt.executeUpdate();
			if (k == 1) {
				ss = "yes";
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ss;
	}

}