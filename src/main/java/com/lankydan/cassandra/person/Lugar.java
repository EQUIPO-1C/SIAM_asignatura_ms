package com.lankydan.cassandra.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.Map;
@AllArgsConstructor
@Getter
@Setter
@Table("lugar")
public class Lugar {
    @PrimaryKey
    private @NonNull int idEdificio;
    private String facultad;
    private String salon;

}
