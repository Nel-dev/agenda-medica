package eam.desarrollo.agenda.interfaces;

import java.util.ArrayList;

import eam.desarollo.agenda.modelo.Profesional;

public interface IntProfesional {

	public abstract void crear(Profesional pro) throws Exception;
	public abstract Profesional buscar(String identificacion) throws Exception;
	public abstract  void eliminar(int identificacion) throws Exception;
	public abstract void actualizar(Profesional pro) throws Exception;
	public abstract void listarProfesional() throws Exception;
	public ArrayList<Profesional> listaProfesional() throws Exception;
}
