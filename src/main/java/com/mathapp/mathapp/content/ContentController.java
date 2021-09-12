package com.mathapp.mathapp.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/content")
@CrossOrigin("*")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @GetMapping("all")
    public List<Content> findAllContents(){
        return contentService.findAll();
    }

    @GetMapping("{contentId}")
    public Content findContentById(@PathVariable Long contentId){
        return contentService.findById(contentId);
    }

    @PostMapping("save")
    public Content saveContent(@RequestBody Content content){
        contentService.save(content);
        return contentService.findLastAdded();
    }

    @DeleteMapping("{contentId}/delete")
    public String deleteContent(@PathVariable Long contentId){
        contentService.deleteById(contentId);
        return String.format("Successfully deleted the content with ID: %d!", contentId);
    }
}
