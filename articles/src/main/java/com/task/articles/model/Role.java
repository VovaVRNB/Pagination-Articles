package com.task.articles.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Setter
@Getter
@EqualsAndHashCode(of = "Id")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @Column(name = "Id", updatable = false, nullable = false)
    private Long Id;

    @Column
    private String name;
}
