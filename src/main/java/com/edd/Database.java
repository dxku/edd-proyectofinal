package com.edd;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

public class Database {
    private JSONArray users;

    public Database(){
        String fileName = "users.json";
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        try
        {
          String usersString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
          users = new JSONArray(usersString);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONArray getUsers() {
        return users;
    }
}
