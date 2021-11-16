package in.ashokit.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String getHomePage() {
		return "HomePage";
	}
	
	@GetMapping("/welcome")
	public String getWelcomePage() {
		return "WelcomePage";
	}
	
	@GetMapping("/admin")
	public String getAdminPage() {
		return "AdminPage";
	}
	
	@GetMapping("/emp")
	public String getempPage() {
		return "EmpPage";
	}
	
	@GetMapping("/mgr")
	public String getmgrPage() {
		return "MgrPage";
	}
	
	@GetMapping("/common")
	public String getcommonPage() {
		return "commonPage";
	}
	
	@GetMapping("/accessDenied")
	public String getAccessDeniedPage() {
		return "accessDeniedPage";
	}
}


