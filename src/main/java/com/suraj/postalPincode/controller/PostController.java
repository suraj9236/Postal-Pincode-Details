package com.suraj.postalPincode.controller;

import com.suraj.postalPincode.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pinDetails")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("pincode-{pincode}")
    public Map<String, Object> getAllBranchesByPincode(@PathVariable int pincode) {
        return postService.pincodeBranch(pincode);
    }
    @GetMapping("branchname-{BranchName}")
    public List<Map<String, Object>> getBranchByPincode(@PathVariable String BranchName){
        return postService.branchDetails(BranchName);
    }

}
