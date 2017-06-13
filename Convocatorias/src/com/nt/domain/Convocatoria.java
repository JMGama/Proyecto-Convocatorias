package com.nt.domain;

import java.util.Date;

public class Convocatoria {

	private int idConvocatoria;
	private String titulo;
	private String objetivo;
	private Date fechaInicial;
	private Date fechaFinal;
	private String requisitos;
	private String bases;
	private String estado;
	private String telefono;
	private String correo;
	private String paginaWeb;
	private String direccion;
	private String responsable;
	private String facebook;
	private String twitter;
	private String youtube;
	private String instagram;
	public int getIdConvocatoria() {
		return idConvocatoria;
	}
	public void setIdConvocatoria(int idConvocatoria) {
		this.idConvocatoria = idConvocatoria;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	public String getBases() {
		return bases;
	}
	public void setBases(String bases) {
		this.bases = bases;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPaginaWeb() {
		return paginaWeb;
	}
	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getYoutube() {
		return youtube;
	}
	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	
	@Override
	public String toString() {
		return "Convocatoria [idConvocatoria=" + idConvocatoria + ", titulo=" + titulo + ", objetivo=" + objetivo
				+ ", fechaInicial=" + fechaInicial + ", fechaFinal=" + fechaFinal + ", requisitos=" + requisitos
				+ ", bases=" + bases + ", estado=" + estado + ", telefono=" + telefono + ", correo=" + correo
				+ ", paginaWeb=" + paginaWeb + ", direccion=" + direccion + ", responsable=" + responsable
				+ ", facebook=" + facebook + ", twitter=" + twitter + ", youtube=" + youtube + ", instagram="
				+ instagram + "]";
	}
	
}
