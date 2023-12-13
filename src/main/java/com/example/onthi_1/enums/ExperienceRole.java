package com.example.onthi_1.enums;

public enum ExperienceRole {
    OWNER(0),
    ADMIN(1),
    LEADER(2),
    MEMBER(3);
    private int type;
    ExperienceRole(int type){
        this.type = type;
    }
    public int getType()
    {
        return type;
    }

    public static ExperienceRole fromType(int type) {
        for (ExperienceRole role : ExperienceRole.values()) {
            if (role.getType() == type) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid ExperienceRole type: " + type);
    }
}
