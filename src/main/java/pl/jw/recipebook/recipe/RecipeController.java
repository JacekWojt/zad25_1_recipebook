package pl.jw.recipebook.recipe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jw.recipebook.category.CategoryRepository;

import java.util.Optional;

@Controller
public class RecipeController {
    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;

    public RecipeController(RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/recipe/{id}")
    public String recipe(@PathVariable Long id, Model model) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (recipeOptional.isPresent()) {
            model.addAttribute("recipe", recipeOptional.get());
            return "recipe";
        } else {
            return "error";
        }
    }

    @GetMapping("/add")
    public String addFormRecipe(Model model) {
        model.addAttribute("recipes", new Recipe());
        model.addAttribute("countryCategories", categoryRepository.findAll());
        return "add";
    }

    @PostMapping("/add")
    public String addRecipe(Recipe recipe) {
        recipe.setLikes(0);
        recipeRepository.save(recipe);
        return "redirect:/";
    }

    @GetMapping("/recipe/{id}/edit")
    public String editFormRecipe(@PathVariable Long id, Model model) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if (recipeOptional.isPresent()) {
            Recipe recipe = recipeOptional.get();
            model.addAttribute("recipeToEdit", recipe);
            model.addAttribute("countryCategories", categoryRepository.findAll());
            return "recipeEdit";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/recipe/{id}/edit")
    public String editRecipe(@PathVariable Long id, Recipe recipe) {
        Recipe recipe1 = recipeRepository.findById(id).orElseThrow();
        recipe1.setName(recipe.getName());
        recipe1.setIngredients(recipe.getIngredients());
        recipe1.setDescription(recipe.getDescription());
        recipe1.setCategory(recipe.getCategory());
        recipeRepository.save(recipe1);
        return "redirect:/recipe/" + recipe.getId();
    }

    @GetMapping("/country/polish")
    public String cuisinePolish(Model model) {
        String countryName = "Polska";
        model.addAttribute("recipes", recipeRepository.findAllByCategory_Country(countryName));
        return "cuisinePolish";
    }

    @GetMapping("/country/french")
    public String cuisineFrench(Model model) {
        String countryName = "Francja";
        model.addAttribute("recipes", recipeRepository.findAllByCategory_Country(countryName));
        return "cuisineFrench";
    }

    @GetMapping("/country/italian")
    public String cuisineItalian(Model model) {
        String countryName = "Włochy";
        model.addAttribute("recipes", recipeRepository.findAllByCategory_Country(countryName));
        return "cuisineItalian";
    }
}
