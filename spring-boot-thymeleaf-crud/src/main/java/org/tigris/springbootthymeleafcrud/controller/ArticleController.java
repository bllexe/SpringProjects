package org.tigris.springbootthymeleafcrud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tigris.springbootthymeleafcrud.model.Article;
import org.tigris.springbootthymeleafcrud.repos.ArticleRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleRepository articleRepository;

    @GetMapping("/articles")
    public String getAllArticles(Model model, @Param("keyword") String keyword){

        List<Article> articleList=new ArrayList<>();
        if(keyword ==null){
            articleList.addAll(articleRepository.findAll());
        }else{
            articleList.addAll(articleRepository.findByTitleContainingIgnoreCase(keyword));
            model.addAttribute("keyword",keyword);
        }
        model.addAttribute("articles",articleList);
        return "articles";
        }

    @GetMapping("/articles/new")
    public String saveArticle(Model model){
        Article article=new Article();
        article.setPublished(true);
        model.addAttribute("article",article);
        model.addAttribute("pageTitle","Add New Article");
        return "article_form";
    }

    @PostMapping("/articles/save")
    public String saveTutorial(Article article, RedirectAttributes redirectAttributes) {
        try {
            articleRepository.save(article);
            redirectAttributes.addFlashAttribute("message", "The Article has been saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addAttribute("message", e.getMessage());
        }
        return "redirect:/articles";
    }


    @GetMapping("/articles/{id}")
    public String editTutorial(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Article article=articleRepository.findById(id).get();
            model.addAttribute("article", article);
            model.addAttribute("pageTitle", "Edit Article (ID: " + id + ")");
            return "article_form";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/articles";
        }
    }
    @GetMapping("/articles/delete/{id}")
    public String deleteTutorial(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            articleRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "The Article with id=" + id + " has been deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/articles";
    }

    @GetMapping("/articles/{id}/published/{status}")
    public String updateTutorialPublishedStatus(@PathVariable("id") Long id, @PathVariable("status") boolean published,
                                                Model model, RedirectAttributes redirectAttributes) {
        try {
            articleRepository.updatePublishedStatus(id, published);
            String status = published ? "published" : "disabled";
            String message = "The Article id=" + id + " has been " + status;
            redirectAttributes.addFlashAttribute("message", message);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/articles";
    }

}
