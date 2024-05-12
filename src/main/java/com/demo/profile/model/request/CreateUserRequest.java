package com.demo.profile.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserRequest implements Serializable {
    @NotEmpty
    private String userRefId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String age;

    private UserPreference userPreference;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserPreference implements Serializable {
        private Boolean balanceShown = false;
        private Boolean marketingConsent = false;
        private Boolean security = false;
        private Boolean location = false;
    }


}
