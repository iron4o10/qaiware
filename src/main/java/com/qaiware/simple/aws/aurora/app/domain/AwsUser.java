package com.qaiware.simple.aws.aurora.app.domain;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "aws_users")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AwsUser {

  @Id
  private String id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false, unique = true)
  private String email;

  public static AwsUser create(String username, String email) {
    AwsUser awsUser = new AwsUser();

    awsUser.setId(UUID.randomUUID().toString());
    awsUser.setUsername(username);
    awsUser.setEmail(email);

    return awsUser;
  }

}
