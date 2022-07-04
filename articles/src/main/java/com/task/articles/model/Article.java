package com.task.articles.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "articles")
@Setter
@Getter
@EqualsAndHashCode(of = "id")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String date;

    @ManyToOne ()
    @JoinColumn(name = "user_id")
    private User user;
}
