package com.task.articles.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Setter
@Getter
@EqualsAndHashCode(of = "Id")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", updatable = false, nullable = false)
    private Long Id;

    @Column
    private String name;

    @Column
    private String password;

    @ManyToOne ()
    @JoinColumn(name = "role_id")
    private Role role;
}
