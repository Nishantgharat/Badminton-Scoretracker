package badminton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Resettst {
	
	Resettst(){
		System.out.println("will delete all");
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/badminton";
			String user = "root";
			String password = "20022002Ng";
			//String query="DELETE FROM player_info ;";
			String query1="DROP table player_info ;";
			String query2="create table player_info (match_no int NOT NULL AUTO_INCREMENT,\n"
					+ "    player_a varchar(20) NOT NULL,\n"
					+ "    player_b varchar(20),\n"
					+ "    winner varchar(20),PRIMARY KEY (match_no));";
			String qry2="DROP table scored ;";
			String qry3="create table scored (score_no int NOT NULL AUTO_INCREMENT,\n"
					+ "    scored_by varchar(20),\n"
					+ "    PRIMARY KEY (score_no));";
			
			
			Connection conn= DriverManager.getConnection(url, user, password);
			
			if (conn != null) {
	          System.out.println("Connected to the database test5");
	      }
			
			
			
			
			Statement stmt=conn.createStatement();
			//Resultset rst= (Resultset) stmt.executeQuery(query);
			
			
			
	        //stmt = conn.prepareStatement(query);
	        PreparedStatement    st = conn.prepareStatement(query1);
	        st.executeUpdate();
	        PreparedStatement    s1 = conn.prepareStatement(query2);
	        s1.executeUpdate();
	        
	        PreparedStatement    st2 = conn.prepareStatement(qry2);
	        st2.executeUpdate();
	        PreparedStatement    st3 = conn.prepareStatement(qry3);
	        st3.executeUpdate();
	        
	        
			
			//(Resultset)rst.next();
//			((ResultSet) rst).next();
//			String name=((ResultSet) rst).getString("name");
//			System.out.println(name);
//			
			
			
				//System.out.print("hello");
			
			//$con = mysqli_connect("localhost","root","","search");
			//echo $con;
		}
		catch(Exception e){System.out.print("hello exc occ"+e);
		}
	}

}
