package com.qaiware.simple.aws.aurora.app.core;

import com.qaiware.simple.aws.aurora.app.api.exceptions.ResourceNotFoundException;
import com.qaiware.simple.aws.aurora.app.api.json.AwsUserRequest;
import com.qaiware.simple.aws.aurora.app.api.json.AwsUserResponse;
import com.qaiware.simple.aws.aurora.app.api.json.AwsUsersResponse;
import com.qaiware.simple.aws.aurora.app.domain.AwsUser;
import com.qaiware.simple.aws.aurora.app.repositories.AwsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwsUserService {

  @Autowired
  private AwsUserRepository awsUserRepository;

  public AwsUsersResponse all() {
    return AwsUsersResponse.create(this.awsUserRepository.findAll());
  }

  public AwsUserResponse show(String id) {
    return AwsUserResponse.create(this.getUserById(id));
  }

  public AwsUserResponse create(AwsUserRequest awsUserRequest) {
    AwsUser awsUser = AwsUser.create(
        awsUserRequest.getUsername(),
        awsUserRequest.getEmail()
    );

    return AwsUserResponse.create(this.awsUserRepository.save(awsUser));
  }

  public AwsUserResponse update(String id, AwsUserRequest awsUserRequest) {
    AwsUser awsUser = this.getUserById(id);

    awsUser.setUsername(awsUserRequest.getUsername());
    awsUser.setEmail(awsUserRequest.getEmail());

    return AwsUserResponse.create(this.awsUserRepository.save(awsUser));
  }

  public void delete(String id) {
    this.awsUserRepository.delete(this.getUserById(id));
  }

  private AwsUser getUserById(String id) {
    return this.awsUserRepository.findById(id)
        .orElseThrow(() -> {
              String errorMessage = "User with id '" + id + "' not found";
              return new ResourceNotFoundException(errorMessage);
            }
        );
  }

}
