package Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main{

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        String inputFilePath = "file2.txt";
        String outputFilePath = "user.json";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            //пропускаємо заголовок
            br.readLine();
            //читаємо кожний наступний рядок
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] columns = line.split("\\s+");
                if (columns.length < 2) {
                    System.err.println("Invalid line format:" + line);
                    continue;
                }
                String name = columns[0];
                int age = Integer.parseInt(columns[1]);
                User user = new User(name, age);
                users.add(user);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (Writer writer = new FileWriter(outputFilePath)) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            gson.toJson(users, writer);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

