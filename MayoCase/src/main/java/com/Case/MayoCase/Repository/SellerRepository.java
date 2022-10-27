package com.Case.MayoCase.Repository;

import com.Case.MayoCase.Model.SellerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface SellerRepository extends JpaRepository<SellerModel, UUID> {

    Optional<SellerModel> findByNameAndEmail(String name, String email);
    @Query("SELECT tb_seller FROM SellerModel tb_seller WHERE " +
            " tb_seller.name= :name AND"+
            " tb_seller.email= :email AND" +
            " tb_seller.id= :id AND" +
            " tb_seller.cpf= :cpf")
    Optional<SellerModel> findToUpdate(String name, String email, UUID id, String cpf);
}
