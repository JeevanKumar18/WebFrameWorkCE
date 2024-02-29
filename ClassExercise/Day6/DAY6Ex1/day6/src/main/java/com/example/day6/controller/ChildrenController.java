package com.example.day6.controller;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day6.model.Children;
import com.example.day6.service.ChildrenService;

@RestController
public class ChildrenController {
    

    private ChildrenService childrenService;

    public ChildrenController(ChildrenService childrenService) {
        this.childrenService = childrenService;
    }
    

    @PostMapping("/api/children")
    public ResponseEntity<Children>postProduct(@RequestBody Children children)
    {
        if(childrenService.saveProduct(children) == true)
        {
            return new ResponseEntity<>(children,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(children,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("api/children/getAll")
    public List<Children>getAll()
    {
        return childrenService.getAllChildren();
    }

    @GetMapping("/api/children/sortBy/{field}")
    public List<Children> sortChild(@PathVariable("field") String field)
    {
        return childrenService.childSortList(field);

    }

    @GetMapping("/api/children/{offset}/{pageSize}")
    public Page<Children> pageChild(@PathVariable int offset ,@PathVariable int pageSize)
    {
        return childrenService.pagination(offset, pageSize);
    }


    @GetMapping("/api/{offset}/{pageSize}/{field}")
    public Page<Children> getMethodName(@PathVariable int offset ,@PathVariable int pageSize ,@PathVariable String field) {
        return childrenService.childPage(offset, pageSize, field);

    
}

}
