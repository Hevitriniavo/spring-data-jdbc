package hei.shool.springdatajdbc.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDTO(
        Long id,
        String username,
        String password,
        RoleDTO role
) {}
