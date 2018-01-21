package com.sinsuren.user.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by surender.s on 20/01/18.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "user_attributes")
public class UserAttributes extends AbstractPersistable<Long> {

    @Column(name = "attribute_key")
    private String attributeKey;

    @Column(name = "attribute_value")
    private String attributeValue;
}
