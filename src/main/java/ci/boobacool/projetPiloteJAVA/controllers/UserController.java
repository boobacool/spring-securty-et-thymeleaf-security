package ci.boobacool.projetPiloteJAVA.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ci.boobacool.projetPiloteJAVA.entities.User;
import ci.boobacool.projetPiloteJAVA.services.TaskService;
import ci.boobacool.projetPiloteJAVA.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;

	@GetMapping("/enregistrer")
	public String enregistrer(Model model) {
		
		model.addAttribute("user", new User());
		
		return "views/enregistreruser";
	}
	
	@PostMapping("/enregistrer")
	public String enregistrerUser(@Valid User user, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "views/enregistreruser";
		}
		if(userService.isUserPresent(user.getEmail())) {
			model.addAttribute("exist", true);
			return "views/enregistreruser";
		}
		userService.createUser(user);
		return "views/success";	
	}
	
	@GetMapping("/utilisateurs")
	public String utilisateurs(Model model, @RequestParam(defaultValue = "") String name) {
		model.addAttribute("users", userService.findByName(name));
		return "views/utilisateurs";
	}
	
	@GetMapping("/profile")
	public String showProfilePage(Model model,Principal principal) {
		
		String email = principal.getName();
		User user = userService.findOne(email);
		
		model.addAttribute("tasks", taskService.findUserTask(user));
		
		return "views/profile";
	}
}
