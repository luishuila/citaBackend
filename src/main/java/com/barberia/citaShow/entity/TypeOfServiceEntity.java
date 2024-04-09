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
@Table(name = "typeOfService")
@Entity
public class TypeOfServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column( nullable=true  )
    private String description;

    @Column( nullable=true  )
    private String gender;

    @OneToMany(mappedBy = "typeOfService")
    private List<ServiceEntity> service;



    @ManyToMany(mappedBy = "typeOfService")
    private List<ProvidersEntity> providers ;


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
