package com.barberia.citaShow.entity;
import java.sql.Timestamp;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import lombok.*;
import jakarta.persistence.*;
/**
*Code generated by The Carpenter from softcaribbean
*/

@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "providers")
@Entity

public class ProvidersEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;


    @Id
	@GeneratedValue( strategy=GenerationType.IDENTITY  )
	@Column( nullable=false  )
	private Long id;

	@Column( nullable=true  )
	private String name;

	@Column( nullable=false  )
	private Long nit;
	@Column( nullable=false  )
	private String invima;
	@Column( nullable=false  )
	private String openDate;
	@Column( nullable=false  )
	private String closeDate;
	@Column( nullable=false  )
	private String ownerId;

	@ManyToOne
	@JoinColumn(name = "id_users")
	private UsersEntity users;

	/*@ManyToMany(mappedBy = "providers")
	private List<UsersEntity> users ;
*/
	@ManyToMany(mappedBy = "providers")
	private List<EmployeeEntity> employee ;


	@OneToMany(mappedBy = "providers")
	private List<AppointmentEntity> appointment;

	@OneToMany(mappedBy = "providers")
	private List<AddresEntity> addres;

	@OneToMany(mappedBy = "providers")
	private List<ServiceEntity> service;

	@ManyToMany
	@JoinTable(name = "providers_typeofservice", joinColumns = @JoinColumn(name = "id_providers"), inverseJoinColumns = @JoinColumn(name = "id_typeOfService"))
	private List<TypeOfServiceEntity> typeOfService ;


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



