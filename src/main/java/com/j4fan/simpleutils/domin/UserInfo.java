package com.j4fan.simpleutils.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "user_info")
@AllArgsConstructor
@Accessors(chain = true)
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String userName;
    private String password;
    private String mobile;
    private String email;

    public UserInfo(){

    }
}
