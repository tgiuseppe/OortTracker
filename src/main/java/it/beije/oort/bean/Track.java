package it.beije.oort.bean;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tracks")
public class Track implements TrackerBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_user")
	private Long idUser;
	
	@Column(name = "start_address")
	private String startAddress;
	
	@Column(name = "end_address")
	private String endAddress;
	
	@Column(name = "start_datetime")
	private Timestamp startDatetime;
	
	@Column(name = "end_datetime")
	private Timestamp endDatetime;
	
	@Column(name = "id_mode")
	private Long idMode;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getStartAddress() {
		return startAddress;
	}

	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}

	public String getEndAddress() {
		return endAddress;
	}

	public void setEndAddress(String endAddress) {
		this.endAddress = endAddress;
	}

	public Timestamp getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(Timestamp startDatetime) {
		this.startDatetime = startDatetime;
	}

	public Timestamp getEndDatetime() {
		return endDatetime;
	}

	public void setEndDatetime(Timestamp endDatetime) {
		this.endDatetime = endDatetime;
	}

	public Long getIdMode() {
		return idMode;
	}

	public void setIdMode(Long idMode) {
		this.idMode = idMode;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder().append("Track [");
		
		sb.append("idUser: ");
		if(idUser == null) {
			sb.append(idUser);
		} else {
			sb.append("\"").append(idUser).append("\"");
		}
		
		sb.append(" - ").append("startAddress: ");
		if(startAddress == null) {
			sb.append(startAddress);
		} else {
			sb.append("\"").append(startAddress).append("\"");
		}
		
		sb.append(" - ").append("endAddress: ");
		if(endAddress == null) {
			sb.append(endAddress);
		} else {
			sb.append("\"").append(endAddress).append("\"");
		}
		
		sb.append(" - ").append("startDatetime: ");
		if(startDatetime == null) {
			sb.append(startDatetime);
		} else {
			sb.append("\"").append(startDatetime).append("\"");
		}
		
		sb.append(" - ").append("endDatetime: ");
		if(endDatetime == null) {
			sb.append(endDatetime);
		} else {
			sb.append("\"").append(endDatetime).append("\"");
		}
		
		sb.append("idMode: ");
		if(idMode == null) {
			sb.append(idMode);
		} else {
			sb.append("\"").append(idMode).append("\"");
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}