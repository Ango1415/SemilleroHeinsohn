package com.hbt.semillero.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

/**
 * 
 * <b>Descripción:</b> Clase que determina el mapeo de la tabla COMIC de la BD DB_SEMILLERO
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
@Entity
@Table(name = "COMIC")
public class Comic implements Serializable { //Tanto la Entidad como el DTO implementan Serializable
	
	/**
	 * Atributo que determina el identificador unico de esta clase  
	 */
	private static final long serialVersionUID = 1L;  //Tanto la Entidad como el DTO implementan este atributo (por implementar Serializable)

	/**
	 * Atributo que determina el mapeo de SCID en la tabla COMIC
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "COMIC_SCID_GENERATOR", sequenceName = "SEQ_COMIC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMIC_SCID_GENERATOR")
	@Column(name = "SCID")
	private Long id;
	
	/**
	 * Atributo que determina el mapeo de SCNOMBRE en la tabla COMIC
	 */
	@Column(name = "SCNOMBRE")
	private String nombre;
	
	/**
	 * Atributo que determina el mapeo de SCEDITORIAL en la tabla COMIC
	 */
	@Column(name = "SCEDITORIAL")
	private String editorial;
	
	/**
	 * Atributo que determina el mapeo de SCTEMATICA en la tabla COMIC
	 */
	@Column(name = "SCTEMATICA")
	@Enumerated(value = EnumType.STRING) //Esta parte hace la conversion de Enumerador a String a la hora de pasar la info a la BD
	private TematicaEnum tematicaEnum;
	
	/**
	 * Atributo que determina el mapeo de SCCOLECCION en la tabla COMIC
	 */
	@Column(name = "SCCOLECCION")
	private String coleccion;
	
	/**
	 * Atributo que determina el mapeo de SCNUMEROPAGINAS en la tabla COMIC
	 */
	@Column(name = "SCNUMEROPAGINAS")
	private Integer numeroPaginas;
	
	/**
	 * Atributo que determina el mapeo de SCPRECIO en la tabla COMIC
	 */
	@Column(name = "SCPRECIO")
	private BigDecimal precio;
	
	/**
	 * Atributo que determina el mapeo de SCAUTORES en la tabla COMIC
	 */
	@Column(name = "SCAUTORES")
	private String autores;
	
	/**
	 * Atributo que determina el mapeo de SCCOLOR en la tabla COMIC
	 */
	@Column(name = "SCCOLOR")
	private Boolean color;
	
	/**
	 * Atributo que determina el mapeo de SCFECHA_VENTA en la tabla COMIC
	 */
	@Column(name = "SCFECHA_VENTA")
	private LocalDate fechaVenta;
	
	/**
	 * Atributo que determina el mapeo de SCESTADO en la tabla COMIC
	 */
	@Column(name = "SCESTADO")
	@Enumerated(value = EnumType.STRING)
	private EstadoEnum estadoEnum;
	
	/**
	 * Atributo que determina el mapeo de SCCANTIDAD en la tabla COMIC
	 */
	@Column(name = "SCCANTIDAD")
	private Integer cantidad;
	

	
	
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo editorial
	 * @return El editorial asociado a la clase
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo editorial
	 * @param editorial El nuevo editorial a modificar.
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo tematica
	 * @return La tematica asociado a la clase
	 */
	public TematicaEnum getTematicaEnum() {
		return tematicaEnum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo tematica
	 * @param tematica El nuevo tematica a modificar.
	 */
	public void setTematicaEnum(TematicaEnum tematicaEnum) {
		this.tematicaEnum = tematicaEnum;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo coleccion
	 * @return El coleccion asociado a la clase
	 */
	public String getColeccion() {
		return coleccion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo coleccion
	 * @param coleccion El nuevo coleccion a modificar.
	 */
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo numeroPaginas
	 * @return El numeroPaginas asociado a la clase
	 */
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo numeroPaginas
	 * @param numeroPaginas El nuevo numeroPaginas a modificar.
	 */
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo precio
	 * @return El precio asociado a la clase
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo precio
	 * @param precio El nuevo precio a modificar.
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo autores
	 * @return El autores asociado a la clase
	 */
	public String getAutores() {
		return autores;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo autores
	 * @param autores El nuevo autores a modificar.
	 */
	public void setAutores(String autores) {
		this.autores = autores;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo color
	 * @return El color asociado a la clase
	 */
	public Boolean getColor() {
		return color;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo color
	 * @param color El nuevo color a modificar.
	 */
	public void setColor(Boolean color) {
		this.color = color;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaVenta
	 * @return El fechaVenta asociado a la clase
	 */
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaVenta
	 * @param fechaVenta El nuevo fechaVenta a modificar.
	 */
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstadoEnum(EstadoEnum estadoEnum) {
		this.estadoEnum = estadoEnum;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo cantidad
	 * @return El cantidad asociado a la clase
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo cantidad
	 * @param cantidad El nuevo cantidad a modificar.
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
