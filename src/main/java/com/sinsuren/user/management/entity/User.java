package com.sinsuren.user.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by surender.s on 15/10/17.
 */
@Data
@EqualsAndHashCode
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="users")
public class User extends AbstractPersistable<Long> implements Serializable {

    @GeneratedValue
    @Column(name="id")
    Long id;

    @Column(name="name", nullable = false)
    String name;

    @Column(name="status", nullable = false)
    String status;
}
