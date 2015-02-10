package es.open4job.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import es.open4job.model.interfaz.FaltaDAOInterface;
import es.open4job.model.vo.FaltaVO;


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

	// Listado de aparcamientos
	public List<FaltaVO> verFaltas(int idAlumno) {

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

		String query = "SELECT * FROM faltas WHERE idAlumno = ? ORDER BY id";

		try {
			pstm = con.prepareStatement(query);
			pstm.setInt(1, idAlumno);

			rs = pstm.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt(1);
				String sesion = rs.getString(3);
				String materia = rs.getString(4);
				String tipo = rs.getString(5);
				String justificado = rs.getString(6);
				String observaciones = rs.getString(7);

				FaltaVO falta = new FaltaVO(id, idAlumno, sesion, materia,
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

	// Obtiene los datos de un aparcamiento en concreto
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
				int idAlumno = rs.getInt(2);
				String sesion = rs.getString(3);
				String materia = rs.getString(4);
				String tipo = rs.getString(5);
				String justificado = rs.getString(6);
				String observaciones = rs.getString(7);

				falta = new FaltaVO(id, idAlumno, sesion, materia, tipo,
						justificado, observaciones);
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

	public List<FaltaVO> verFaltas() {
		// TODO Auto-generated method stub
		return null;
	}

	public void actualizarFalta(FaltaVO falta) {
		// TODO Auto-generated method stub
		
	}

	public void borrarFalta(int id) {
		// TODO Auto-generated method stub
		
	}

}
