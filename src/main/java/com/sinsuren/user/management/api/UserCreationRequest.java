package com.sinsuren.user.management.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sinsuren.user.management.entity.UserAttributeKey;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Map;

/**
 * Created by surender.s on 15/10/17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCreationRequest {
    @NotEmpty
    private String name;

    private Map<UserAttributeKey, String> attributes;
}
