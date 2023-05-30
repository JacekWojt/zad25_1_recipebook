package pl.jw.recipebook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.jw.recipebook.category.CategoryRepository;
import pl.jw.recipebook.recipe.Recipe;
import pl.jw.recipebook.recipe.RecipeRepository;

import java.util.List;

@Controller
public class HomeController {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;

    public HomeController(RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "home";
    }

    @GetMapping("/recipe/{id}/like")
    public String like(@PathVariable Long id) {
        Recipe recipe1 = recipeRepository.findById(id).orElseThrow();
        int likes = recipe1.getLikes();
        recipe1.setLikes(likes + 1);
        recipeRepository.save(recipe1);
        return "redirect:/";
    }

    @GetMapping("/popular")
    public String popular(Model model) {
        List<Recipe> allOrderByLikesAsc = recipeRepository.findAllByOrderByLikesDesc();
        model.addAttribute("recipes", allOrderByLikesAsc);
        return "popular";
    }

    @GetMapping("/recipe/{id}/delete")
    public String delete(@PathVariable Long id) {
        recipeRepository.deleteById(id);
        return "redirect:/";
    }
}
