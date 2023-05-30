package pl.jw.recipebook.recipe;

import jakarta.persistence.*;
import pl.jw.recipebook.category.Category;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String ingredients;
    @Column(length = 5000)
    private String description;

    private int likes;

    @ManyToOne
    private Category category;

    public Recipe() {
    }

    public Recipe(String name, String ingredients, String description, int likes, Category category) {
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.likes = likes;
        this.category = category;
    }

    public Recipe(Long id, String name, String ingredients, String description, int likes, Category category) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.likes = likes;
        this.category = category;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
