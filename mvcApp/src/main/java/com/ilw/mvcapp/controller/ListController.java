/**
 * 
 */
package com.ilw.mvcapp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ilw.mvcapp.config.AppConfig;
import com.ilw.mvcapp.model.List;
import com.ilw.mvcapp.rest.dto.StatusDTO;
import com.ilw.mvcapp.service.ListService;

/**
 * @author Scott
 *
 */
@RestController
@RequestMapping("/list")
public class ListController {
	private static final Logger logger = LoggerFactory.getLogger(ListController.class);
	
    AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
    
	private ListService listService = context.getBean(ListService.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String homeRequest(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "redirect:list";
	}
	
	@GetMapping("/{listID}")
	public List getList(@PathVariable("listID") long listID) {
		System.out.println(listService.getList(listID));
		return listService.getList(listID);
	}
	
	@CrossOrigin(origins = "http://www.todolist.com:8080", maxAge = 3600)
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public java.util.List<List> allLists() {
		java.util.List<List> list = listService.getAllLists();
		return list;
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public List editList(@RequestBody List list){
		list = listService.updateList(list);
		return list; 
	}
	
	@CrossOrigin(origins = "http://www.todolist.com:8080", maxAge = 3600)
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addList(@ModelAttribute List list){
		list = listService.addList(list);
		return "list";
	}
	 
	@RequestMapping(value="/delete/{listID}",method=RequestMethod.GET)
	public StatusDTO delete(@PathVariable("listID") long listID){
		listService.deleteList(listID);
		StatusDTO status = new StatusDTO();
		status.setMessage("List Deleted Successfully");
		status.setStatus(200);
		return status;
	}
}
