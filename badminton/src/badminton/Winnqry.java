package badminton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Winnqry extends MatchUI
{

	Winnqry(String a,String b,int n1)
	{
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/badminton";
			String user = "root";
			String password = "20022002Ng";
			String query="";
			if(n1==0) {
			 query="UPDATE player_info SET winner = '"+a+"' WHERE player_a='"+a+"' and player_b='"+b+"';";
			}
			else if(n1==1) {
			 query="UPDATE player_info SET winner = '"+b+"' WHERE player_a='"+a+"' and player_b='"+b+"';";

			}
			Connection conn= DriverManager.getConnection(url, user, password);
			
			if (conn != null) {
              System.out.println("Connected to the database test3");
          }
			
			Statement stmt=conn.createStatement();
			//Resultset rst= (Resultset) stmt.executeQuery(query);
			
			
			System.out.println("This is from winn"+query);
	        //stmt = conn.prepareStatement(query);
	        PreparedStatement    st = conn.prepareStatement(query);
	        st.executeUpdate();
	        
	        conn.close();
	        
		}
		catch(Exception e){System.out.print("hello exc occ"+e);
		}
	}
}
