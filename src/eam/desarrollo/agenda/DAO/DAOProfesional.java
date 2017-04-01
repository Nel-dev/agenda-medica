package eam.desarrollo.agenda.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultButtonModel;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import eam.desarollo.agenda.modelo.Profesional;
import eam.desarrollo.agenda.interfaces.IntProfesional;

public class DAOProfesional implements IntProfesional {

	Conexion dao=new Conexion();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void crear(Profesional pro) {
		// TODO Auto-generated method stub
//		
try {
            
            String sql = "INSERT INTO  profesional(Idprofesional,nombre_profesional,apellido_profesional,identificacion_profesional,area_profesional,telefono_profesional,direccion_profesional)"+" VALUES(?,?,?,?,?,?,?)";
//             System.out.println(sql);
           
            Connection con = Conexion.getConexion();
            java.sql.PreparedStatement stm = con.prepareStatement(sql);
            
            stm.setInt(1, pro.getIdprofesional());
            stm.setString(2, pro.getNombreProfesional());
            stm.setString(3, pro.getApellidoProfesional());
            stm.setInt(4, pro.getIdentificacionProfesional());
            stm.setString(5, pro.getAreaProfesional());
            stm.setString(6, pro.getTelefonoProfesional());
            stm.setString(7, pro.getDireccionProfesional());
            stm.executeUpdate();
            
        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
           //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }



	}

	

	@Override
	public void actualizar(Profesional pro) {
		
try {
            
            String sql = "UPDATE profesional SET nombre_profesional=?,apellido_profesional=?,area_profesional=?,telefono_profesional=?,direccion_profesional=? WHERE identificacion_profesional=?";

            Connection con = Conexion.getConexion();
            java.sql.PreparedStatement stm = con.prepareStatement(sql);
            
            
            stm.setString(1, pro.getNombreProfesional());
            stm.setString(2, pro.getApellidoProfesional());
            stm.setString(3, pro.getAreaProfesional());
            stm.setString(4, pro.getTelefonoProfesional());
            stm.setString(5, pro.getDireccionProfesional());
            stm.setInt(6, pro.getIdentificacionProfesional());
            stm.executeUpdate();
           // System.out.println(sql);
            
        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
       
           //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}

	

	@Override
	public Profesional buscar(String identificacion) throws Exception {
		// TODO Auto-generated method stub
		Connection con = Conexion.getConexion();

		String sql = "SELECT * FROM profesional " + " WHERE identificacion_profesional=?";
		java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, identificacion);
		// ejecutar consulta
		java.sql.ResultSet res = pstmt.executeQuery();
		Profesional cust = null;
		// hubo un registro....
		if (res.next()) {
			int id=res.getInt(1);
			String nombre = res.getString(2);
			String apellido = res.getString(3);
			int cedula= res.getInt(4);
			String area = res.getString(5);
			String telefono = res.getString(6);
			String direccion= res.getString(7);

			cust = new Profesional(id,nombre,apellido,cedula,area,telefono,direccion);
			System.out.println(cust);
			return cust;
		}
		con.close();
		return null;
		
	
	}

	@Override
	public void eliminar(int identificacion) throws Exception {
		try{
			Connection con = Conexion.getConexion();
			String sql="delete from profesional where identificacion_profesional=?";
			java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, identificacion);
			pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public void listarProfesional() throws Exception {
		try {
			Connection con = Conexion.getConexion();
			    java.sql.Statement st = con.createStatement();
			    java.sql.ResultSet res = st.executeQuery("select * from profesional");
			    while (res.next()) {
			    
			    	 System.out.print(res.getString(1));
				        System.out.print(res.getString(2));
				        System.out.print(res.getString(3));
				        System.out.print(res.getString(4));
				        System.out.print(res.getString(5));
				        System.out.print(res.getString(6));
				        System.out.println(res.getString(7));
				   
			       
			        
			    }
			} catch (SQLException e) {
			    e.printStackTrace();
			}
	}

	@Override
	public ArrayList<Profesional> listaProfesional() throws Exception {
		ArrayList<Profesional> pro = new ArrayList<Profesional>();
		Connection con = Conexion.getConexion();
		java.sql.PreparedStatement ps=con.prepareStatement("select * from profesional");
		java.sql.ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Profesional profesional = new Profesional(rs.getInt("IdProfesional"),rs.getString("nombre_profesional"),rs.getString("apellido_profesional"),rs.getInt("identificacion_profesional"),
					rs.getString("area_Profesional"),rs.getString("telefono_profesional"),rs.getString("direccion_profesional"));
			pro.add(profesional);
					 
		}
		rs.close();
		return pro;
	}

	


	
	
}


