package mx.com.microservicio.apg.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Empleado implements Serializable{
	private static final long serialVersionUID = 1L;
	//Attribute
	@Id
	private String matricula;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column(columnDefinition = "DECIMAL(10,2)")
	private double sueldo;	
	@Column(name = "fechaAlta")
	@Temporal(TemporalType.DATE)
	public Date fechaAlta;
	//Method
	@PrePersist
	public void prePersist() {
		fechaAlta = new Date();
	}
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, fechaAlta, matricula, nombre, sueldo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(fechaAlta, other.fechaAlta)
				&& Objects.equals(matricula, other.matricula) && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(sueldo) == Double.doubleToLongBits(other.sueldo);
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	@Override
	public String toString() {
		return "Empleado [matricula=" + matricula + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sueldo="
				+ sueldo + ", fechaAlta=" + fechaAlta + "]";
	}
	
}
