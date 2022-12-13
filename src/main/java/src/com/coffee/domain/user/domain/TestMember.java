package src.com.coffee.domain.user.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="member")
public class TestMember {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	private String userid;
	
	private String password;
	private String email;
	
	
	public TestMember() {
		super();
	}

	public TestMember(String userid, String password, String email) {
		this.userid=userid;
		this.password=password;
		this.email=email;
	}

}
