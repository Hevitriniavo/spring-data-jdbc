package hei.shool.springdatajdbc.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RoleDTO(Long id, String name) {}

