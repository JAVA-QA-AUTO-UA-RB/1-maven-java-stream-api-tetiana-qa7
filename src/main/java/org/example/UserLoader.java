package org.example;

import org.example.dto.User;

import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;


public class UserLoader {

    private static final Gson gson = new Gson(); // Create a Gson object

    public static List<User> loadUsersFromJson(String filePath) throws IOException {//

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                UserLoader.class.getClassLoader().getResourceAsStream(filePath)))) {

            if (reader == null) {
                throw new FileNotFoundException("File not found in classpath: " + filePath);
            }
            Type userListType = new TypeToken<List<User>>() {}.getType(); // Define the type of the list of Users
            //userListType is a Type object created using TypeToken.
            //It's used to provide Gson with the necessary type information to deserialize JSON into a List<User>.
            //TypeToken: This is a special class used by Gson to handle generic types. I want to deserialize into a list of User objects, so I have to specify the type of the list.
            return gson.fromJson(reader, userListType);//// Deserialize the JSON content into a List of Users
            //fromJson: This method of the Gson object is used to deserialize the JSON content into a list of User objects.
            }}

        // Додайте реалізацію метода, який з JSON файлу який знаходиться за відносним шляхом filepath
        // з допомогою вбудованих засобів бібліотеки https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1
        // десеріалізує контент JSON файлу у список з об*єктів типу User і повертає список



}
