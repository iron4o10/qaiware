package com.qaiware.simple.aws.aurora.app.api.json;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AwsUserRequest {

  @NotEmpty
  private String username;
  
  @NotEmpty
  private String email;

}
