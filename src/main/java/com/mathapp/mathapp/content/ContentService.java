package com.mathapp.mathapp.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class ContentService {
    @Autowired
    private ContentRepository contentRepository;

    public void save(Content content){
        contentRepository.save(content);
    }

    public List<Content> findAll() {
        return contentRepository.findAll();
    }

    public Content findById(Long contentId) {
        Optional<Content> content = contentRepository.findById(contentId);
        return content.orElse(null);
    }

    public Content findLastAdded(){
        return contentRepository.findTopByOrderByIdDesc();
    }

    public void deleteById(Long contentId){
        contentRepository.deleteById(contentId);
    }
}
