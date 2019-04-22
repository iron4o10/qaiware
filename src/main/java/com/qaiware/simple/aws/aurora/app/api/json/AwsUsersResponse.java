package com.qaiware.simple.aws.aurora.app.api.json;

import com.qaiware.simple.aws.aurora.app.domain.AwsUser;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AwsUsersResponse {

  private List<AwsUserResponse> users;

  public static AwsUsersResponse create(List<AwsUser> awsUsers) {
    AwsUsersResponse awsUsersResponse = new AwsUsersResponse();

    awsUsersResponse.setUsers(
        awsUsers
            .stream()
            .map(AwsUserResponse::create)
            .collect(Collectors.toList())
    );

    return awsUsersResponse;
  }

}
