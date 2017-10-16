package com.sinsuren.user.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

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
public class User {

    @GeneratedValue
    @Column(name="id")
    Long id;

    @Column(name="name", nullable = false)
    String name;

    @Column(name="status", nullable = false)
    String status;
}
