package es.open4job.model.vo;

import java.util.Date;

public class FaltaVO {

	private int id;
	private int id_alumno;
	private Date fecha;
	private String sesion;
	private String materia;
	private String tipo;
	private String justificado;
	private String observaciones;

	public FaltaVO() {
	}
	
	public FaltaVO(int id, int id_alumno, Date fecha, String sesion, String materia,
			String tipo, String justificado, String observaciones) {
		this.id = id;
		this.id_alumno = id_alumno;
		this.fecha = fecha;
		this.sesion = sesion;
		this.materia = materia;
		this.tipo = tipo;
		this.justificado = justificado;
		this.observaciones = observaciones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}	

	public String getSesion() {
		return sesion;
	}

	public void setSesion(String sesion) {
		this.sesion = sesion;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getJustificado() {
		return justificado;
	}

	public void setJustificado(String justificado) {
		this.justificado = justificado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String toString() {
		return ("[" + "id = " + id + ", id_alumno = " + id_alumno + ", fecha = "
				+ fecha + ", sesion = "	+ sesion + ", materia = " + materia + ", tipo = " + tipo
				+ ", justificado = " + justificado + ", observaciones = " + observaciones + "]");
	}
	
}
