package org.example;

import org.example.dto.User;
import org.example.helpers.ResourceLoader;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {

    public static final String INPUT_FILENAME = "users.json";

    public static void main(String[] args) throws IOException {
        // Не змінюйте чотири рядки нижче
        String inputFileName = INPUT_FILENAME;
        String jsonFilePath = ResourceLoader.getResourcePath(inputFileName);
        List<User> importedUsers = UserLoader.loadUsersFromJson(jsonFilePath);
        List<User> filteredAndSortedUsers = UserProcessor.filterAndSortUsers(importedUsers);

        //Переконайтеся, що в результаті виконання програми ДІЙСНО надрукується
        //список юзерів, які відфільтровані і відсортовані за вказаними критеріями
        filteredAndSortedUsers.forEach(System.out::println);

        //
        URL resourceUrl = UserLoader.class.getClassLoader().getResource("users.json");
        if (resourceUrl == null) {
            System.out.println("Resource URL is null.");
        } else {
            System.out.println("Resource URL: " + resourceUrl.getPath());
        }


    }
}