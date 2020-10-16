package it.beije.oort.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements TrackerBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nickname")
	private String nickname;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "password")
	private String password;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder().append("User [");
		
		sb.append("nickname: ");
		if(nickname == null) {
			sb.append(nickname);
		} else {
			sb.append("\"").append(nickname).append("\"");
		}
		
		sb.append(" - ").append("mail: ");
		if(mail == null) {
			sb.append(mail);
		} else {
			sb.append("\"").append(mail).append("\"");
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}
