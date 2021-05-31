package badminton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class rset {
	
	rset(){
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/badminton";
			String user = "root";
			String password = "20022002Ng";
			String qry2="DROP table scored ;";
			String qry3="create table scored (score_no int NOT NULL AUTO_INCREMENT,\n"
					+ "    scored_by varchar(20),\n"
					+ "    PRIMARY KEY (score_no));";
			Connection conn= DriverManager.getConnection(url, user, password);
			
			
			
			
			
			
			Statement stmt=conn.createStatement();
			//Resultset rst= (Resultset) stmt.executeQuery(query);
			
			
			
	        //stmt = conn.prepareStatement(query);
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
