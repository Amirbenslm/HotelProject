package Reservationpack;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;


public class AffichageJtable {
	JTable jt;
	int c,l=0,i;
	String[] cn;
	String[][] mat;
	JTable retourJtable(ResultSet rs){
	 try {
		 //while(rs.next()) l++;
		java.sql.ResultSetMetaData md= rs.getMetaData();
		c=md.getColumnCount();
		 cn=new String[c];
		 l=100;
		mat=new String[l][c];
		for(int k=0;k<c;k++)
		{cn[k]=md.getColumnLabel(k+1);}
		i=0;
		while(rs.next())
		{
			for(int j=0;j<c;j++)
			{mat[i][j]=rs.getString(j+1);
		}
		i++;
		}
		 jt=new JTable(mat,cn);
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 
	 
	 return jt;
	
	}
	}


