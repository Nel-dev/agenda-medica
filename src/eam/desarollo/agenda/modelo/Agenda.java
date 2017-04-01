package eam.desarollo.agenda.modelo;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * Model class of Agenda.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Agenda implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Hora1. */
	private int hora1;

	/** Hora2. */
	private int hora2;

	/** IdProfesional. */
	private Integer idprofesional;

	/** fecha. */
	private Date fecha;

	
	/**
	 * 
	 * @param hora1
	 * @param hora2
	 * @param idprofesional
	 * @param fecha
	 */
	public Agenda(Integer hora1, Integer hora2, Integer idprofesional, Date fecha) {
		super();
		this.hora1 = hora1;
		this.hora2 = hora2;
		this.idprofesional = idprofesional;
		this.fecha = fecha;
	}

	/**
	 * Constructor.
	 */
	public Agenda() {
	}

	public int getHora1() {
		return hora1;
	}

	public void setHora1(int hora1) {
		this.hora1 = hora1;
	}

	public int getHora2() {
		return hora2;
	}

	public void setHora2(int hora2) {
		this.hora2 = hora2;
	}

	public Integer getIdprofesional() {
		return idprofesional;
	}

	public void setIdprofesional(Integer idprofesional) {
		this.idprofesional = idprofesional;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
