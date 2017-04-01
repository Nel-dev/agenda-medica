package eam.desarrollo.agenda.DAO;


import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Conexion {
    private static java.sql.Connection con;
    private Statement stm;
    private ResultSet rs;

    

    public static Connection getConexion() throws SQLException {
        try {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            String database = "agendaMedica";
            String usuario  = "root";
            String clave    = "root";
            con =  DriverManager.getConnection(
            "jdbc:mysql://localhost/"+database+"?"
            + "user="+usuario+"&password="+clave);
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, e.toString(), "Info",
					JOptionPane.INFORMATION_MESSAGE);
        	
        }
        /**
        finally {
        	JOptionPane.showMessageDialog(null, "conexion exitosa", "Info",
					JOptionPane.INFORMATION_MESSAGE);
        }
        **/
        return (Connection) con;
    }

}
