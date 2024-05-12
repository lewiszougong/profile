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
@Table(name = "user_preference")
public class UserPreferenceEntity implements Serializable {

    @Id
    @Column(name = "user_ref_id", nullable = false)
    private String userRefId;
    @Column(name = "balance_shown", nullable = false)
    private Boolean balanceShown;
    @Column(name = "marketing_consent", nullable = false)
    private Boolean marketingConsent;
    @Column(name = "security", nullable = false)
    private Boolean security;
    @Column(name = "location", nullable = false)
    private Boolean location;
}
