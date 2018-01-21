package com.sinsuren.user.management.entity;

import com.sinsuren.user.management.core.statemachine.StatefulEntity;
import com.sinsuren.user.management.statemachine.user.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by surender.s on 15/10/17.
 */
@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="users")
@Repository
@Component
public class User extends AbstractPersistable<Long> implements StatefulEntity<UserStatus, Long> {

    @Column(name="name", nullable = false)
    String name;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    UserStatus status;

    @OneToMany(targetEntity = UserAttributes.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", name="user_id")
    private List<UserAttributes> attributes;
}