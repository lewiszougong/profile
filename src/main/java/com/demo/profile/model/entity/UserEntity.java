package com.demo.profile.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_profile")
public class UserEntity implements Serializable {

    @Id
    @Column(name = "user_ref_id", nullable = false)
    private String userRefId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "age", nullable = false)
    private String age;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "created_date", nullable = false)
    private ZonedDateTime createdDate;
}
