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
 * Token generated by hbm2java
 */
@Entity
@Table(name = "TOKEN", schema = "PRUEBAH")
@XmlRootElement(name = "token")
public class Token implements java.io.Serializable {

	private BigDecimal idToken;
	private Usuario usuario;
	private String codigo;

	public Token() {
	}

	public Token(BigDecimal idToken, Usuario usuario, String codigo) {
		this.idToken = idToken;
		this.usuario = usuario;
		this.codigo = codigo;
	}

	@Id
	@Column(name = "ID_TOKEN", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdToken() {
		return this.idToken;
	}

	public void setIdToken(BigDecimal idToken) {
		this.idToken = idToken;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_USUARIO", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "CODIGO", nullable = false, length = 100)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
