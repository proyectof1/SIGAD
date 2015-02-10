package es.open4job.model.interfaz;

import java.util.List;

import es.open4job.model.vo.FaltaVO;


public interface FaltaDAOInterface {
/* defines standard operations to be performed on POJO*/
   public abstract List<FaltaVO> verFaltas(int idAlumno);
   public abstract FaltaVO verDatosFalta(int id);
   public abstract void actualizarFalta(FaltaVO falta);
   public abstract void borrarFalta(int id);
}