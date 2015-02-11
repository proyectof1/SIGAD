package es.open4job.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import es.open4job.model.interfaz.FaltaDAOInterface;
import es.open4job.model.vo.FaltaVO;

@ManagedBean
@SessionScoped
public class FaltaDAO implements FaltaDAOInterface {

	private DataSource ds = null;
	// get database connection
	private Connection con = null;

	public FaltaDAO() {

		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/opensigad");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		if (ds == null)
			try {
				throw new SQLException("No se puede obtener la fuente de datos");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}

	// Listado de las faltas de un alumno
	public List<FaltaVO> verFaltasAlumno(int id_alumno) {

		try {
			con = ds.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (con == null)
			try {
				throw new SQLException(
						"No se puede obtener la conexión de base de datos");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		List<FaltaVO> faltas = new ArrayList<FaltaVO>();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String query = "SELECT * FROM faltas WHERE id_alumno = ? ORDER BY id";
		
		try {
			pstm = con.prepareStatement(query);
			pstm.setInt(1, id_alumno);

			rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				Date fecha = rs.getDate(3);
				String sesion = rs.getString(4);
				String materia = rs.getString(5);
				String tipo = rs.getString(6);
				String justificado = rs.getString(7);
				String observaciones = rs.getString(8);

				FaltaVO falta = new FaltaVO(id, id_alumno, fecha, sesion, materia,
						tipo, justificado, observaciones);
				
				faltas.add(falta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (Exception e) {
				}
			}
		}

		return faltas;
	}

	// Ver los datos de una falta 
	public FaltaVO verDatosFalta(int idFalta) {

		try {
			con = ds.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (con == null)
			try {
				throw new SQLException(
						"No se puede obtener la conexión de base de datos");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		FaltaVO falta = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String query = "SELECT * FROM faltas WHERE id = ?";

		try {
			pstm = con.prepareStatement(query);
			pstm.setInt(1, idFalta);

			rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				int id_alumno = rs.getInt(2);
				Date fecha = rs.getDate(3);
				String sesion = rs.getString(4);
				String materia = rs.getString(5);
				String tipo = rs.getString(6);
				String justificado = rs.getString(7);
				String observaciones = rs.getString(8);

				falta = new FaltaVO(id, id_alumno, fecha, sesion, materia, tipo,
						justificado, observaciones);
				
				//falta.add(falta);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (Exception e) {
				}
			}
		}

		return falta;
	}

	public void actualizarFalta(int idFalta) {
		
		try {
			con = ds.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (con == null)
			try {
				throw new SQLException(
						"No se puede obtener la conexión de base de datos");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		FaltaVO falta = null;
		PreparedStatement pstm = null;
		int cantidad = 0;

		String query = "UPDATE faltas SET tipo = 'xxx' WHERE id = ?";
		
		try {
			pstm = con.prepareStatement(query);
			pstm.setInt(1, idFalta);
			cantidad = pstm.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if (pstm != null) {
				try {
					pstm.close();
				} catch (Exception e) {
				}
			}
		}
		
	}

	
	public void borrarFalta(int idFalta) {
		
		try {
			con = ds.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (con == null)
			try {
				throw new SQLException(
						"No se puede obtener la conexión de base de datos");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		FaltaVO falta = null;
		PreparedStatement pstm = null;
		int cantidad = 0;

		String query = "DELETE FROM faltas WHERE id = ?";
		
		try {
			pstm = con.prepareStatement(query);
			pstm.setInt(1, idFalta);
			cantidad = pstm.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if (pstm != null) {
				try {
					pstm.close();
				} catch (Exception e) {
				}
			}
		}
		
	}

	public List<FaltaVO> verFaltas() {
		try {
			con = ds.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (con == null)
			try {
				throw new SQLException(
						"No se puede obtener la conexión de base de datos");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		List<FaltaVO> faltas = new ArrayList<FaltaVO>();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String query = "SELECT * FROM faltas ORDER BY id";
		
		try {
			pstm = con.prepareStatement(query);
			rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				int id_alumno = rs.getInt(2);
				Date fecha = rs.getDate(3);
				String sesion = rs.getString(4);
				String materia = rs.getString(5);
				String tipo = rs.getString(6);
				String justificado = rs.getString(7);
				String observaciones = rs.getString(8);

				FaltaVO falta = new FaltaVO(id, id_alumno, fecha, sesion, materia,
						tipo, justificado, observaciones);
				
				faltas.add(falta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (Exception e) {
				}
			}
		}

		return faltas;
		
	}

}
