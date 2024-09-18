package com.kodbook.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kodbook.entities.Post;
import com.kodbook.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class NavigationController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/openSignUp")
	public String openSignUp() {
		return "SignUp";
	}
	@GetMapping("/openCreatePost")
	public String openCreatePost() {
		return "CreatePost";
	}
	@GetMapping("/goHome")
	public String login(Model model)	{
		List<Post> allPosts = postService.fetchAllPosts();
			model.addAttribute("allPosts", allPosts);
			return "home";
	}
	@GetMapping("/openMyProfile")
	public String openMyProfile(Model model,HttpSession session) {
		String username=(String)session.getAttribute("username");
		User user=service.getUser(username);
		model.addAttribute("user",user);
		return "myProfile";
	}
	
	@GetMapping("/openEditProfile")
	public String openEditProfile() {
		return "editProfile";
	}
}
