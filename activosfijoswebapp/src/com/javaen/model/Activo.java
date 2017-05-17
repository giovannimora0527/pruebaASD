package com.javaen.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="activos")
public class Activo{
	
	private int id;	
	private String activo;
	private String descripcion;	
	private TipoActivo tipo;
	private String serial;
	private String numInventario;
	private Float peso;
	private Float alto;
	private Float ancho;
	private Float largo;
	private Long valorCompra;
	private Date fechaCompra;
	private Date fechaBaja;
	private String estado;
	private Integer color;
	
	
	public Activo(){}

	@Id	
	@Column(name="act_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="nombre_activo")
	public String getActivo() {
		return activo;
	}

	public void setActivo(String nombre) {
		this.activo = nombre;
	}

	@Column(name="descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name="serial")
	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	@Column(name="num_inventario")
	public String getNumInventario() {
		return numInventario;
	}

	public void setNumInventario(String numInventario) {
		this.numInventario = numInventario;
	}

	@Column(name="peso")
	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	@Column(name="alto")
	public Float getAlto() {
		return alto;
	}

	public void setAlto(Float alto) {
		this.alto = alto;
	}

	@Column(name="ancho")
	public Float getAncho() {
		return ancho;
	}

	public void setAncho(Float ancho) {
		this.ancho = ancho;
	}

	@Column(name="largo")
	public Float getLargo() {
		return largo;
	}

	public void setLargo(Float largo) {
		this.largo = largo;
	}

	@Column(name="valor_compra")
	public Long getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Long valorCompra) {
		this.valorCompra = valorCompra;
	}

	@Column(name="fecha_compra")
	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	@Column(name="fecha_baja")
	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	@Column(name="estado")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}	
	
	@JoinColumn(name="tipo")
	@OneToOne
	public TipoActivo getTipo() {
		return tipo;
	}

	public void setTipo(TipoActivo tipo) {
		this.tipo = tipo;
	}

	@Column(name="color")
	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}
		
	
}
