package codesquad.springcafe.controller;

import codesquad.springcafe.DB.ArticleDatabase;
import codesquad.springcafe.domain.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @PostMapping("/article")
    // @ModelAttribute 어노테이션 을 통해 Post body를 파싱해 article 객체로 반환한다.
    public String saveArticle(@ModelAttribute Article article) {
        article.setId(Integer.toString(ArticleDatabase.getArticleSize()+1)); // article id 설정
        ArticleDatabase.saveArticle(article);
        logger.debug("new article: " + article.toString());

        // article를 저장 후 main 페이지로 redirect
        return "redirect:/main";
    }

}
