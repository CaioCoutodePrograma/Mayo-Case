package com.Case.MayoCase.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_SELLER")
public class SellerModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "char(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "email")
    private String email;
    @ManyToMany(mappedBy = "sellers")
    private Set<ClientModel> clients = new HashSet<>();
}
