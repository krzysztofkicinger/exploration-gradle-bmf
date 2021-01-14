package com.kicinger.exploration.gradle.contract;

import lombok.Value;

import java.util.List;

@Value
public class User {
    String username;
    List<Permission> permissions;
}
