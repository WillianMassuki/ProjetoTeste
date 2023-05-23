package br.comvarejonline.projetoinicial.user.repository;

import br.comvarejonline.projetoinicial.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findbyUsername(String username);

}
