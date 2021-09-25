package com.example.sharedpreferences_a_0181.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.sharedpreferences_a_0181.Model.User;

public class UserPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public static final String IS_LOGIN="isLogin";
    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";

    public UserPreferences(Context context) {
        this.context=context;
        sharedPreferences=context.getSharedPreferences("userPreferences",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public void setLogin(String username, String password) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PASSWORD, password);

        editor.commit();
    }

    public User getUserLogin() {
        String username,password;

        username=sharedPreferences.getString(KEY_USERNAME, null);
        password=sharedPreferences.getString(KEY_PASSWORD, null);

        return new User(username,password);
    }

    public boolean checkLogin() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public void logout() {
        editor.clear();
        editor.commit();
    }
}
