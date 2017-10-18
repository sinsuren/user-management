package com.sinsuren.user.management.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.concurrent.Immutable;
import javax.validation.constraints.NotNull;

/**
 * Created by surender.s on 17/10/17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserVerificationRequest {
    @NotNull
    private Long id;
}
