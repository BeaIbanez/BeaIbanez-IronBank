package com.ironbank.http.requestUser;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    String username;
    String password;
    String email;
    String firstname;
    String lastname;
    String primaryAddress;
    String phoneNumber;
}