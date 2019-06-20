package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.connection.GetConnection;
import com.training.pom.LoginPOM_ELTC_001;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class ELearningDAO {
	
	Properties properties; 
	private LoginPOM_ELTC_001 loginPOM1;

	public ELearningDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<LoginBean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<LoginBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<LoginBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				LoginBean temp = new LoginBean(); 
				temp.setUserName(gc.rs1.getString(1));
				temp.setPassword(gc.rs1.getString(2));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	//----------------------
	
	public Boolean insertintoSQLDB()
	{
		GetConnection gc  = new GetConnection(); 
		Boolean returnstatus=true;
		try {
			
			//String query = "INSERT INTO student (firstname, lastname, email, username, password, phonenum) VALUES ("+"'"+loginPOM1.getFirstName()+"', '"+loginPOM1.getLastName()+"', '"+loginPOM1.getEmail()+"', '"+loginPOM1.getRegUserName()+"', '"+loginPOM1.getPassword()+"', '"+loginPOM1.getphone()+"')";
			String query1 = "insert into student (firstname, lastname, email, username, password, phonenum)"
			        + " values (?, ?, ?, ?, ?, ?)";
			System.out.println("this is query1..................................");
			System.out.println(query1);
			gc.ps2=GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(query1);
			gc.ps2.setString(1, "manjoor");
			gc.ps2.setString(2, "manjoor");
			gc.ps2.setString(3, "manjoor@gmail.com");
			gc.ps2.setString(4, "manjoor");
			gc.ps2.setString(5, "manjoor");
			gc.ps2.setString(6, "1234567890");
			returnstatus=gc.ps2.execute();
			gc.ps2.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	return returnstatus;
	}
	public List<LoginBean> setRegistration(){
		
		
		String sql = properties.getProperty("get.reg");
		GetConnection gc  = new GetConnection(); 
		
		List<LoginBean> list = null;
		try {
			
			//String query = "INSERT INTO student (firstname, lastname, email, username, password, phonenum) VALUES ("+"'"+loginPOM1.getFirstName()+"', '"+loginPOM1.getLastName()+"', '"+loginPOM1.getEmail()+"', '"+loginPOM1.getRegUserName()+"', '"+loginPOM1.getPassword()+"', '"+loginPOM1.getphone()+"')";
			String query1 = "insert into student (firstname, lastname, email, username, password, phonenum)"
			        + " values (?, ?, ?, ?, ?, ?)";
			System.out.println("this is query1..................................");
			System.out.println(query1);
			gc.ps2=GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(query1);
			gc.ps2.setString(0, "manjoor");
			gc.ps2.setString(1, "manjoor");
			gc.ps2.setString(2, "manjoor@gmail.com");
			gc.ps2.setString(3, "manjoor");
			gc.ps2.setString(4, "manjoor");
			gc.ps2.setString(5, "1234567890");
			gc.ps2.execute();
			
			
			/*      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      preparedStmt.setString (1, "Barney");
			      preparedStmt.setString (2, "Rubble");
			      preparedStmt.setDate   (3, startDate);
			      preparedStmt.setBoolean(4, false);
			      preparedStmt.setInt    (5, 5000);

			      // execute the preparedstatement
			      preparedStmt.execute();*/
			      
			
			
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<LoginBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				LoginBean temp = new LoginBean(); 
				temp.setFirstName(gc.rs1.getString(1));
				temp.setLastName(gc.rs1.getString(2));
				temp.setEmail(gc.rs1.getString(3));
				temp.setRegUserName(gc.rs1.getString(4));
				temp.setRegPassword(gc.rs1.getString(5));
				temp.setPhone(gc.rs1.getString(6));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	//---------------------

	public static void main(String[] args) {
		new ELearningDAO().getLogins().forEach(System.out :: println);
	}
	
	
}
