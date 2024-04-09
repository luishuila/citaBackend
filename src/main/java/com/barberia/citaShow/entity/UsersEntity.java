package com.barberia.citaShow.entity;

import java.io.Serializable;

import com.barberia.citaShow.config.SecurityConfig;
import com.barberia.citaShow.mapper.RoleMapper;
import com.barberia.citaShow.util.UtilEntity;
import lombok.*;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.time.LocalDate;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "users")
@Entity

public class UsersEntity extends UtilEntity implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String nickname;
	@Column(nullable = false)
	private String lastname;


	@Column(nullable = false)
	private String gender;

	@Column( nullable=true )
	private LocalDate birth ;

	@Column( nullable=true)
	private boolean   locked;

	@Column( nullable=true)
	private boolean   typespolitics;
	@Column( nullable=true)
	private boolean   politics;


	@ManyToMany(mappedBy = "users")
	private List<RoleEntity> role ;



	@OneToMany(mappedBy = "users")
	private List<AppointmentEntity> appointment;

	@OneToMany(mappedBy = "users")
	private List<ProvidersEntity> providers;



	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
	private EmployeeEntity employee;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "deleted_at")
	private Timestamp deletedAt;




	@PrePersist
	public void createdAtInsert() {

		this.createdAt = new Timestamp(System.currentTimeMillis());;
	}
	@PreUpdate
	public  void updatedAt(){
		this.updatedAt = new Timestamp(System.currentTimeMillis());;
	}

	@PreRemove
	public  void  deletedAt(){
		this.deletedAt = new Timestamp(System.currentTimeMillis());;
	}

}
