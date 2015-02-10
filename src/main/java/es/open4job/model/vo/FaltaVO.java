package es.open4job.model.vo;

public class FaltaVO {

	private int id;
	private int idAlumno;
	private String sesion;
	private String materia;
	private String tipo;
	private String justificado;
	private String obtervaciones;

	public FaltaVO() {
	}
	
	public FaltaVO(int id, int idAlumno, String sesion, String materia,
			String tipo, String justificado, String obtervaciones) {
		this.id = id;
		this.idAlumno = idAlumno;
		this.sesion = sesion;
		this.materia = materia;
		this.tipo = tipo;
		this.justificado = justificado;
		this.obtervaciones = obtervaciones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
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

	public String getObtervaciones() {
		return obtervaciones;
	}

	public void setObtervaciones(String obtervaciones) {
		this.obtervaciones = obtervaciones;
	}

	public String toString() {
		return ("[" + "id = " + id + ", idAlumno = " + idAlumno + ", sesion = "
				+ sesion + ", materia = " + materia + ", tipo = " + tipo
				+ ", justificado = " + justificado + ", obtervaciones = " + obtervaciones + "]");
	}	
	
}
