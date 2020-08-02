package me.github.wert.sophperms.utils;

import me.github.wert.sophperms.Main;

public enum Rank
{
    //TODO.md: Permissions (StringList & can this work via config??), Priority for Inheritance...

    MEMBER("MEMBER","&7",1),
    ONESTAR("ONESTAR","&d⭐",2),
    TWOSTAR("TWOSTAR","&d⭐⭐",3),
    THREESTAR("THREESTAR","&d⭐⭐⭐",3),
    TRAINEE("TRAINEE","&eTrainee",15),
    MOD("MOD","&2Mod",16),
    SRMOD("SRMOD","&2&oSr Mod",17),
    ADMIN("ADMIN","&6Admin",18),
    DEV("DEV","&cDev",19),
    MANAGER("MANAGER","&4Manager",20),
    OWNER("OWNER","&4Manager",21);

    private final int priority;
    private final String prefix;
    private final String name;

    Rank(String name, String prefix,int priority)
    {
        this.name = name;
        this.prefix = prefix;
        this.priority = priority;
    }
    public boolean hasPrefix()
    {
        return prefix != null;
    }
    public int getPriority()
    {
        return priority;
    }
    public String getPrefix()
    {
        return prefix;
    }
    public String getName() {return name;}
}