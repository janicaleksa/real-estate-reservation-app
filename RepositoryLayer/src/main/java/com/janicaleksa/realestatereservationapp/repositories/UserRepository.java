package com.janicaleksa.realestatereservationapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.janicaleksa.realestatereservationapp.entities.UserAccount;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, String> {

	Optional<UserAccount> findByUsernameAndPassword(String username, String password);
}
