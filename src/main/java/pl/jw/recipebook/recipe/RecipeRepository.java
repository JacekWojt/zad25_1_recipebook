package pl.jw.recipebook.recipe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAllByOrderByLikesDesc();

    List<Object> findAllByCategory_Country(String countryName);
}
