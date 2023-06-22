package com.nt.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishMessageService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class WishMessageController {

	@Autowired
	private IWishMessageService service;

//	@GetMapping("/")
	@RequestMapping("/")
	public String showHomePage() {
		return "home";
	}

	/*@RequestMapping("/wish")
	public ModelAndView showWishMsgPage() {
		// Use Service class.
		String msg = service.generateWishMsg();
		// Create & return ModelAndView object.
		return new ModelAndView("display", "wMsg", msg);
	}*/

	/*@RequestMapping("/wish")
	public ModelAndView showWishMsgPage() {
		ModelAndView mav = null;
		// Use Service class.
		String msg = service.generateWishMsg();
		// Create ModelAndView object.
		mav = new ModelAndView();
		mav.addObject("wMsg", msg);
		mav.setViewName("display");
		return mav;
	}*/

	/*@RequestMapping("/wish")
	public String showWishMsgPage(BindingAwareModelMap map) {
	System.out.println("Shared Memory Oject Class Name : " + map.getClass());
		// Use Service class.
		String msg = service.generateWishMsg();
		// Add Model attribute to Map object.
		map.addAttribute("wMsg", msg);
		// Return Logical View Name.
		return "display";
	}*/

	/*@RequestMapping("/wish")
	public String showWishMsgPage(ModelMap map) {
	System.out.println("Shared Memory Oject Class Name : " + map.getClass());
		// Use Service class.
		String msg = service.generateWishMsg();
		// Add Model attribute to Map object.
		map.addAttribute("wMsg", msg);
		// Return Logical View Name.
		return "display";
	}*/

	/*@RequestMapping("/wish")
	public String showWishMsgPage(Model map) {
	System.out.println("Shared Memory Oject Class Name : " + map.getClass());
		// Use Service class.
		String msg = service.generateWishMsg();
		// Add Model attribute to Map object.
		map.addAttribute("wMsg", msg);
		// Return Logical View Name.
		return "display";
	}*/

	/*@RequestMapping("/wish")
	public String showWishMsgPage(HashMap map) {
	System.out.println("Shared Memory Oject Class Name : " + map.getClass());
		// Use Service class.
		String msg = service.generateWishMsg();
		// Add Model attribute to Map object.
		map.put("wMsg", msg);
		// Return Logical View Name.
		return "display";
	}*/

	/*@RequestMapping("/wish")
	public String showWishMsgPage(Map map) {
	System.out.println("Shared Memory Oject Class Name : " + map.getClass());
		// Use Service class.
		String msg = service.generateWishMsg();
		// Add Model attribute to Map object.
		map.put("wMsg", msg);
		// Return Logical View Name.
		return "display";
	}*/

	/*@RequestMapping("/wish")
	public void showWishMsgPage(Map map) {
		// Use Service class.
		String msg = service.generateWishMsg();
		// Add Model attribute to Map object.
		map.put("wMsg", msg);
	}*/

	/*@RequestMapping("/wish")
	public Model showWishMsgPage() {
		// Use Service class.
		String msg = service.generateWishMsg();
		// Create Model class object.
		Model model = new ExtendedModelMap();
		// Add Model attribute to Map object.
		model.addAttribute("wMsg", msg);
		// Return Model object.
		return model;
	}*/

	/*@RequestMapping("/wish")
	public Map<String, Object> showWishMsgPage() {
		// Use Service class.
		String msg = service.generateWishMsg();
		// Create Model class object.
		Map<String, Object> map = new HashMap();
		// Add Model attribute to Map object.
		map.put("wMsg", msg);
		// Return Model object.
		return map;
	}*/

	/*@RequestMapping("/wish")
	public void showWishMsgPage(HttpServletResponse res) throws Exception {
		// Use Service class.
		String msg = service.generateWishMsg();
		// Get PrintWriter object pointing to Response object.
		PrintWriter pw = res.getWriter();
		// Set response content type.
		res.setContentType("text/html");
		pw.println("<b> Wish Message : " + msg + "<b>");
		pw.close();
	//		return;
	}*/

	@RequestMapping("/wish")
	public String showWishMsgPage(HttpServletResponse res) throws Exception {
		// Use Service class.
		String msg = service.generateWishMsg();
		// Get PrintWriter object pointing to Response object.
		PrintWriter pw = res.getWriter();
		// Set response content type.
		res.setContentType("text/html");
		pw.println("<b> Wish Message : " + msg + "<b>");
		pw.close();
		return null;
	}

}// class
