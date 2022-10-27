package com.Case.MayoCase.Repository;

import com.Case.MayoCase.Model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ClientRepository extends JpaRepository<ClientModel, UUID>{
    Optional<ClientModel> findByNameAndEmail(String name, String email);
    @Query("SELECT tb_client FROM ClientModel tb_client WHERE tb_client.name= :name AND"+
            " tb_client.email= :email AND" +
            " tb_client.id= :id AND" +
            " tb_client.cpf= :cpf")
    Optional<ClientModel> findToUpdate(String name, String email, UUID id,String cpf);
}
