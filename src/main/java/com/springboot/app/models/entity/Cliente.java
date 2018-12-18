package com.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	private String apellido;
	private String email;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE) 
	private Date createAt;
	
	public final long getId() {return id;}
	public final void setId(long id) {this.id = id;}
	public final String getNombre() {return nombre;}
	public final void setNombre(String nombre) {this.nombre = nombre;}
	public final String getApellido() {return apellido;}
	public final void setApellido(String apellido) {this.apellido = apellido;}
	public final String getEmail() {return email;}
	public final void setEmail(String email) {this.email = email;}
	public final Date getCreateAt() {return createAt;}
	public final void setCreateAt(Date createAt) {this.createAt = createAt;}

}
