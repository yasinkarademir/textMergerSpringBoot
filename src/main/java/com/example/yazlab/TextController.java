package com.example.yazlab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class TextController {
    @Autowired
    private TextRepository textRepository;

    @PostMapping("/merge")

    public String mergeText(@RequestParam("textArray") String[] textArray) {

        System.out.println(Arrays.toString(textArray));
        List<String> texts = Arrays.asList(textArray);


        long start = new Date().getTime();

        String mergedText = TextMerger.mergeTexts(textArray);
        long end = new Date().getTime();
        long elapsedTime = end - start;

        TextEntity textEntity = new TextEntity(texts, mergedText, elapsedTime);
        textRepository.save(textEntity);


        return "redirect:/";
    }




    @GetMapping("/merged-texts")
    public String list(Model model) {
        List<TextEntity> texts = textRepository.findAll();


        model.addAttribute("texts", texts);
        return "sonuclar";


    }




}


