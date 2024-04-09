package com.barberia.citaShow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "employee")
@Entity

public class EmployeeEntity {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY  )
    @Column( nullable=false  )
    private Long id;


    @Column( nullable=false  )
    private Long numberIdentification;

    @Column( nullable=true  )
    private String typeIdentification;

    @Column( nullable=true  )
    private Boolean available;

    @Column( nullable=true  )
    private Boolean checkpoint;



    @ManyToMany
    @JoinTable(name = "employee_providers", joinColumns = @JoinColumn(name = "id_employee"), inverseJoinColumns = @JoinColumn(name = "id_providers"))
    private List<ProvidersEntity> providers ;


    @OneToOne
    @JoinColumn(name = "id_users")
    private UsersEntity users;

    @OneToMany(mappedBy = "employee")
    private List<AppointmentEntity> appointment;

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
