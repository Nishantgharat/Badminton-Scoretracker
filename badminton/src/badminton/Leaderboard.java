package badminton;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

public class Leaderboard {
	Leaderboard(){
	JFrame framed = new JFrame();
	framed.setBounds(150, 70, 850, 850);                                                               
	//framed.setLayout(null);                                                                            
	framed.setVisible(true);
	framed.setSize(500,700);
	
	
	
	
	
	System.out.println("this will show leaderboard ");
	DefaultTableModel defaultTableModel;
	defaultTableModel = new DefaultTableModel();
	JTable table;
	table = new JTable(defaultTableModel);
    table.setPreferredScrollableViewportSize(new Dimension(300, 100));
    table.setFillsViewportHeight(true);
    framed.add(new JScrollPane(table));
    defaultTableModel.addColumn("match_no");
    
    defaultTableModel.addColumn("Winner");
    
    
	
	
    try {	
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/badminton";
		String user = "root";
		String password = "20022002Ng";
		String query="select match_no,winner from player_info ;";
		
		Connection conn= DriverManager.getConnection(url, user, password);
		
		if (conn != null) {
          System.out.println("Connected to the database test5");
      }
		
		Statement stmt=conn.createStatement();
		Resultset rst= (Resultset) stmt.executeQuery(query);
		
		//(Resultset)rst.next();
//		((ResultSet) rst).next();
//		String name=((ResultSet) rst).getString("name");
//		System.out.println(name);
//		
		
		while (((ResultSet) rst).next()) {
			//System.out.println(((ResultSet) rst).getString("player_a"));
			//String name1=((ResultSet) rst).getString("player_a");
			//System.out.println(((ResultSet) rst).getString("player_b"));
			//String name2=((ResultSet) rst).getString("player_b");
			String matchno=((ResultSet) rst).getString("match_no");
			String winner=((ResultSet) rst).getString("winner");
			
			defaultTableModel.addRow(new Object[]{matchno,winner});
			//System.out.print("hello");
		}
		//$con = mysqli_connect("localhost","root","","search");
		//echo $con;
	}
	catch(Exception e){System.out.print("hello exc occ"+e);
	}

}}
