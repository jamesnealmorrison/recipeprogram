package com.jimmie.recipeprogram;

import com.jimmie.recipeprogram.domain.Ethnicity;
import com.jimmie.recipeprogram.domain.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.Scanner;

@SpringBootApplication
public class RecipeprogramApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeprogramApplication.class, args);
    }

}

@SpringBootApplication
public class RecipeProgramMain {
    public static void main(String[] args) {
        RecipeProgramMain recipeProgramMain = new RecipeProgramMain();
        recipeProgramMain.run();
    }

    private void run() {
        boolean done = false;
        while (!done) {
            done = doSomething();
        }
    }

    private boolean doSomething() {
        System.out.println("Welcome to Jim's old school recipe app!");
        System.out.println("What do you want to do?");
        System.out.println("1. Add recipe.");
        System.out.println("2. Search for recipes.");
        System.out.println("3. Quit.");
        int option = getIntOption(1,3);
        System.out.println("You chose " + option);

        switch (option) {
            case 1:
                addRecipe();
                break;
            case 2:
                searchRecipes();
                break;
            case 3:
                return true;
        }
        return false;
    }

    private void searchRecipes() {

    }

    private void addRecipe() {
        Recipe recipe = new Recipe();
        System.out.print("What is the name of the recipe? ");
        recipe.setName(getStringInput());
        System.out.print("What is the source of the recipe? ");
        recipe.setSource(getStringInput());
        recipe.setTimesCooked(0);
        recipe.setEthnicity(getEthnicity());
    }

    private Ethnicity getEthnicity() {
        RestTemplate restTemplate = new RestTemplate();
        Ethnicity jimEthnicity = restTemplate.getForObject("http://localhost:8080/ethnicity?id=1", Ethnicity.class);
        ResponseEntity<Ethnicity> responseEntity = restTemplate.getForEntity("http://localhost:8080/ethnicity?id=1", Ethnicity.class);
        Ethnicity ethnicity = responseEntity.getBody();
        ResponseEntity<Ethnicity[]> response = restTemplate.getForEntity("http://localhost:8080/allEthnicities", Ethnicity[].class);
        Ethnicity[] ethnicities = response.getBody();
        return null;
    }

    private String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int getIntOption(int min, int max) {
        int option = -1;
        Scanner scanner = new Scanner(System.in);
        while (option < min || option > max) {
            System.out.print("Please choose a number between " + min + " and " + max + ": ");
            option = scanner.nextInt();
        }
        return option;
    }
}
