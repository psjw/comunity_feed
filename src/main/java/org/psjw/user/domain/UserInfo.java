package org.psjw.user.domain;

public class UserInfo {
    private final String name;
    private final String prifileImageUrl;

    public UserInfo(String name, String profileImageUrl) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.prifileImageUrl = profileImageUrl;
    }
}
