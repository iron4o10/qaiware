package com.qaiware.simple.aws.aurora.app.repositories;

import com.qaiware.simple.aws.aurora.app.domain.AwsUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwsUserRepository extends JpaRepository<AwsUser, String> {

  Optional<AwsUser> findByUsername(String username);

}
