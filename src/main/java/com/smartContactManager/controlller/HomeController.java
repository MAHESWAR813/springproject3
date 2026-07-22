package com.smartContactManager.controlller;

/*import com.smartContactManager.entities.Contact;
import com.smartContactManager.entities.User;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;*/

import com.smartContactManager.dao.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartContactManager.entities.User;

@Controller
public class HomeController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "smart concat manager");
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "about_smart contact manager");
		return "about";
		
	}
	
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("user",new User());	
				return "signUp";
	}
	
	//this handler for registration user
	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("user") User user,@RequestParam(value= "agreement",defaultValue="false") boolean agreement,Model model) {
		if(!agreement) {
			System.out.println("Agreement is not checked!!");
		}
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		System.out.print("Agreement :"+agreement);
		System.out.println("User: "+user);
		User result = this.userRepository.save(user);
		model.addAttribute("user",result);
		return "signUp";
	}


}
