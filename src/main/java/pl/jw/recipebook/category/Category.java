package pl.jw.recipebook.category;

import jakarta.persistence.*;
import pl.jw.recipebook.recipe.Recipe;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    @OneToMany(mappedBy = "category")
    private List<Recipe> recipe;

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.country = name;
    }

    public Category(String name) {
        this.country = name;
    }

    public List<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<Recipe> recipe) {
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String name) {
        this.country = name;
    }
}
