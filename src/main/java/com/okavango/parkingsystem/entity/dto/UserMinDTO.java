package com.okavango.parkingsystem.entity.dto;

import com.okavango.parkingsystem.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserMinDTO {

    private Long id;
    private String userName;
    private String role;

    public UserMinDTO(User user){
        String roleUser = String.valueOf(user.getRole());
        id = user.getId();
        userName = user.getUserName();
        role = roleUser.substring("ROLE_".length());
    }

}
