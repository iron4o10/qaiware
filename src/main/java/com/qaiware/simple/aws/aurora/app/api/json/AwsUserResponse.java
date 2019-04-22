package com.qaiware.simple.aws.aurora.app.api.json;

import com.qaiware.simple.aws.aurora.app.domain.AwsUser;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AwsUserResponse {

  private String id;

  private String username;

  private String email;

  public static AwsUserResponse create(AwsUser awsUser) {
    AwsUserResponse awsUserResponse = new AwsUserResponse();

    awsUserResponse.setId(awsUser.getId());
    awsUserResponse.setUsername(awsUser.getUsername());
    awsUserResponse.setEmail(awsUser.getEmail());

    return awsUserResponse;
  }

}
