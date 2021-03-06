package entidad;

// Generated Sep 14, 2015 4:50:05 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * UsuarioMoneda generated by hbm2java
 */
@Entity
@Table(name = "USUARIO_MONEDA", schema = "PRUEBAH")
@XmlRootElement(name = "usuarioMoneda")
public class UsuarioMoneda implements java.io.Serializable {

	private BigDecimal idUsuMoneda;
	private Moneda moneda;
	private UsuarioDetalle usuarioDetalle;

	public UsuarioMoneda() {
	}

	public UsuarioMoneda(BigDecimal idUsuMoneda, Moneda moneda,
			UsuarioDetalle usuarioDetalle) {
		this.idUsuMoneda = idUsuMoneda;
		this.moneda = moneda;
		this.usuarioDetalle = usuarioDetalle;
	}

	@Id
	@Column(name = "ID_USU_MONEDA", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdUsuMoneda() {
		return this.idUsuMoneda;
	}

	public void setIdUsuMoneda(BigDecimal idUsuMoneda) {
		this.idUsuMoneda = idUsuMoneda;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_MONEDA", nullable = false)
	public Moneda getMoneda() {
		return this.moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_USUD", nullable = false)
	public UsuarioDetalle getUsuarioDetalle() {
		return this.usuarioDetalle;
	}

	public void setUsuarioDetalle(UsuarioDetalle usuarioDetalle) {
		this.usuarioDetalle = usuarioDetalle;
	}

}
