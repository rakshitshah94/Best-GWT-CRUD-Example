package com.gwtfiler.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwtfiler.client.UploadedData;
import com.gwtfiler.shared.UploadFile;

public class UploadedDataImpl extends RemoteServiceServlet implements UploadedData {
	List<UploadFile> listOfUploadFiles = new ArrayList<UploadFile>();
	private static final long serialVersionUID = 1L;
	Connection con = null;
	Statement stmt = null;
	String url = "jdbc:mysql://localhost:3306/test";

	public void getDBConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, "root","");
	}

	@Override
	public List<UploadFile> selectUploadedFiles(int id, String topic, String stream, String Tag, String plink,
			String fpath, Boolean checkboxstatus) {
		try {
			getDBConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM uploadfile";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				UploadFile uf = new UploadFile();
				uf.setId(rs.getInt(1));
				uf.setTopic(rs.getString(2));
				uf.setStream(rs.getString(3));
				uf.setTag(rs.getString(4));
				uf.setPlink(rs.getString(5));
				uf.setFpath(rs.getString(6));
				uf.isCheckboxstatus(rs.getBoolean(7));

				listOfUploadFiles.add(uf);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfUploadFiles;
	}

	public Boolean removeData(int i) {
		int k = 0;
		Boolean ss = false;
		try {

			getDBConnection();
			stmt = con.createStatement();
			String sql = "DELETE FROM uploadfile WHERE id =" + i;
			k = stmt.executeUpdate(sql);

			if (k == 1) {
				ss = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ss;
	}

	@Override
	public List<UploadFile> getData() {
		return listOfUploadFiles;
	}

	@Override
	public Boolean editData(int id, String topic, String stream, String Tag, String plink, String fpath) {
		int flag = 0;
		Boolean ss = false;
		try {
			getDBConnection();
			stmt = con.createStatement();
			String sql = "UPDATE UPLOADFILE SET topic ='" + topic + "',stream = '" + stream + "',Tag = '" + Tag
					+ "',PublicLink = '" + plink + "',FileBody = '" + fpath + "' WHERE id=" + id;
			flag = stmt.executeUpdate(sql);
			if (flag == 1) {
				ss = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ss;
	}

	@Override
	public List<UploadFile> forUpdateUploadedFiles(int id) {
		try {
			getDBConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM uploadfile WHERE id="+id;
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				UploadFile uf = new UploadFile();
				uf.setId(rs.getInt(1));
				uf.setTopic(rs.getString(2));
				uf.setStream(rs.getString(3));
				uf.setTag(rs.getString(4));
				uf.setPlink(rs.getString(5));
				uf.setFpath(rs.getString(6));
				uf.isCheckboxstatus(rs.getBoolean(7));

				listOfUploadFiles.add(uf);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfUploadFiles;
	}

}
