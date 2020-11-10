package com.offcn.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix="userbody")

public class UserBody {

    private String name;
    private String password;
    private String birthday;
    private String mobile;
    private String address;

}
