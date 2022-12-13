package src.com.coffee.domain.user.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_Id")
	private String userId;
	
	private String auth_code;
	private String file_master_seq;
	private String user_pass;
	private String user_nm;
	private String user_ctnt;
	private String user_addr;
	private String user_mail;
	private String user_tel;
	private String user_keyword;
	@CreatedDate
	private Date user_reg_date;
	private Date user_update_date;
	private String user_type;
	
	public User() {
		super();
	}

	@Builder
	public User(String userId, String auth_code, String file_master_seq, String user_pass, String user_nm,
			String user_ctnt, String user_addr, String user_mail, String user_tel, String user_keyword,
			Date user_reg_date, Date user_update_date, String user_type) {
		super();
		this.userId = userId;
		this.auth_code = auth_code;
		this.file_master_seq = file_master_seq;
		this.user_pass = user_pass;
		this.user_nm = user_nm;
		this.user_ctnt = user_ctnt;
		this.user_addr = user_addr;
		this.user_mail = user_mail;
		this.user_tel = user_tel;
		this.user_keyword = user_keyword;
		this.user_reg_date = user_reg_date;
		this.user_update_date = user_update_date;
		this.user_type = user_type;
	}

}
