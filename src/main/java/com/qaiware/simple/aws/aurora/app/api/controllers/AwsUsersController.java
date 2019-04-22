package com.qaiware.simple.aws.aurora.app.api.controllers;

import com.qaiware.simple.aws.aurora.app.api.json.AwsUserRequest;
import com.qaiware.simple.aws.aurora.app.core.AwsUserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class AwsUsersController {

  @Autowired
  private AwsUserService awsUserService;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<?> all() {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(this.awsUserService.all());
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> show(@PathVariable(value = "id") String id) {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(this.awsUserService.show(id));
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<?> create(@Valid @RequestBody AwsUserRequest awsUserRequest) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(this.awsUserService.create(awsUserRequest));
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
  public ResponseEntity<?> update(
      @PathVariable(value = "id") String id,
      @Valid @RequestBody AwsUserRequest awsUserRequest
  ) {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(this.awsUserService.update(id, awsUserRequest));
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<?> delete(@PathVariable(value = "id") String id) {
    this.awsUserService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
