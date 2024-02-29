package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.model.Book;
import java.util.Date;

@RestController
@RequestMapping("/date")
public class BookController {
    @GetMapping("/Book")
    public Book getMethodName() {
        Date curr = new Date();
        return new Book("The Great Soldier", "G. Gyan", curr);
    }
}
