package com.upadhyay.newsfeedapplication.db.table;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class UserProfile {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    private int userId;

    @ColumnInfo(name = "userName")
    private String userName;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "salt")
    private String salt;

    public UserProfile(String userName, String password, String salt) {
        this.userName = userName;
        this.password = password;
        this.salt = salt;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
