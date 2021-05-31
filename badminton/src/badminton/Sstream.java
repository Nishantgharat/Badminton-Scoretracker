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

public class Sstream {
	Sstream()
	{
		JFrame framef = new JFrame();
		framef.setBounds(150, 70, 850, 850);                                                               
		//framef.setLayout(null);                                                                            
		framef.setVisible(true);
		framef.setSize(400,500);
		
		
		
		
		
		
		
		DefaultTableModel defaultTableModel;
		defaultTableModel = new DefaultTableModel();
		JTable table;
		table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        table.setFillsViewportHeight(true);
        framef.add(new JScrollPane(table));
        defaultTableModel.addColumn("score number");
        defaultTableModel.addColumn("scored by");
        
	    
	    
		
		
	    try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/badminton";
			String user = "root";
			String password = "20022002Ng";
			String query="select * from scored ";
			
			Connection conn= DriverManager.getConnection(url, user, password);
			
			
			
			Statement stmt=conn.createStatement();
			Resultset rst= (Resultset) stmt.executeQuery(query);
			
			
			
			while (((ResultSet) rst).next()) {
				String scrno=((ResultSet) rst).getString("score_no");
				String scrd=((ResultSet) rst).getString("scored_by");
				
				defaultTableModel.addRow(new Object[]{scrno,scrd});
				//System.out.print("hello");
			}
			//$con = mysqli_connect("localhost","root","","search");
			//echo $con;
		}
		catch(Exception e){System.out.print("hello exc occ"+e);
		}
	}
}
