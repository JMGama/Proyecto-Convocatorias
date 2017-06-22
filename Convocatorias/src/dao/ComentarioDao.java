package dao;

public class ComentarioDao {
	
	private int idComentario;
	private String comentario;
	private String seccion;
	private String estado;
	private int fkConvocatoria;
	
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getFkConvocatoria() {
		return fkConvocatoria;
	}
	public void setFkConvocatoria(int fkConvocatoria) {
		this.fkConvocatoria = fkConvocatoria;
	}
	
	
}
