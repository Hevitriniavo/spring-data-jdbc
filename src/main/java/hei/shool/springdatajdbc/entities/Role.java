package hei.shool.springdatajdbc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    private Long id;

    private String name;

    @MappedCollection(idColumn = "role")
    Set<User> users;
}
