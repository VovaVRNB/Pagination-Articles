package com.task.articles.dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String name;
    private String password;
}
