package badminton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Tracker extends MatchUI {
	
	Tracker(int num){
		
		
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/badminton";
			String user = "root";
			String password = "20022002Ng";
			String qry="insert into scored (scored_by) values ('"+playerAName+"');  ";
			String qry1="insert into scored (scored_by) values ('"+playerBName+"');  ";
			

              System.out.println(qry);

			Connection conn= DriverManager.getConnection(url, user, password);
			
			if (conn != null) {
              System.out.println("Connected to the database test3");
          }
			
			Statement stmt=conn.createStatement();
			//Resultset rst= (Resultset) stmt.executeQuery(query);
			
			
			
	        //stmt = conn.prepareStatement(query);
			
			
			
			
			if(num==0)
			{		System.out.println(MatchUI.playerAName);
			PreparedStatement    st = conn.prepareStatement(qry);
	        st.executeUpdate();
		    }
			else {
				System.out.println(MatchUI.playerBName);
				PreparedStatement    st1 = conn.prepareStatement(qry1);
		        st1.executeUpdate();
			
			}
	        
	        
	        
	        
	        conn.close();
			
			//(Resultset)rst.next();
//			((ResultSet) rst).next();
//			String name=((ResultSet) rst).getString("name");
//			System.out.println(name);
//			
			
//			while (((ResultSet) rst).next()) {
//				System.out.println(((ResultSet) rst).getString("scored_by"));	
//				System.out.print("hello");
//			}
			//$con = mysqli_connect("localhost","root","","search");
			//echo $con;
		}
		catch(Exception e){System.out.print("hello exc occ"+e);
		}
		
		
		
		
		
		
		
		
		
		
}}
