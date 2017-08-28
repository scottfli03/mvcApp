/**
 * 
 */
package com.ilw.mvcapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ilw.mvcapp.config.AppConfig;
import com.ilw.mvcapp.model.List;
import com.ilw.mvcapp.model.ListItem;
import com.ilw.mvcapp.rest.dto.StatusDTO;
import com.ilw.mvcapp.service.ListItemService;
import com.ilw.mvcapp.service.ListService;

/**
 * @author Scott
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/")
public class ListController {
	private static final Logger logger = LoggerFactory.getLogger(ListController.class);
	
    AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
    
	private ListService listService = context.getBean(ListService.class);
	private ListItemService listItemService = context.getBean(ListItemService.class);
	
	/**
	 * Checks if a connection to the database is persisted.
	 * @return True if connected
	 */
	@GetMapping({"/connected"})
	public boolean ableToConnect() {
		return listService.ableToConnect();
	}
	
	// --------- Lists ---------- //
	// http://www.mvcapp.com:8081/v1/{listID}	Get		*
	// http://www.mvcapp.com:8081/v1/{listID}	DELETE	*
	// http://www.mvcapp.com:8081/v1/lists		Get		*
	// http://www.mvcapp.com:8081/v1/lists 		Post	*
	// http://www.mvcapp.com:8081/v1/lists 		Patch	*
	// -------- ListItems --------- //
	// http://www.mvcapp.com:8081/v1/{listID}/listitems	Get			*	
	// http://www.mvcapp.com:8081/v1/listitems/{itemID}	Get			*
	// http://www.mvcapp.com:8081/v1/{listID}			Post		*
	// http://www.mvcapp.com:8081/v1/listitems/{itemID}	Delete		*
	// http://www.mvcapp.com:8081/v1/listitems/{itemID} Patch		*
	
	
	// --------- Lists ---------- //
	
	/**
	 * Returns a list object based on listID
	 * @param listID
	 * @return a List object
	 */
	@GetMapping("/{listID}")
	public List getList(@PathVariable("listID") long listID) {
		System.out.println(listService.getList(listID));
		return listService.getList(listID);
	}
	
	/**
	 * Returns all list objects
	 * @return	a List of List objects
	 */
	@RequestMapping(value="/lists",method=RequestMethod.GET)
	public java.util.List<List> allLists() {
		java.util.List<List> list = listService.getAllLists();
		return list;
	}
	
	/**
	 * Updates a list
	 * @param	list The new List object used to update the old List Object
	 * @return	The new list object.
	 */
	@RequestMapping(value="/lists",method=RequestMethod.PATCH)
	public List editList(@RequestBody List list){
		list = listService.updateList(list);
		return list; 
	}
	
	/**
	 * Add a List Object to the Lists Table
	 * @param list
	 * @return
	 */
	@RequestMapping(value="/lists",method=RequestMethod.POST)
	public String addList(@RequestBody List list){
		list = listService.addList(list);
		return list.toString();
	}
	
	/**
	 * Delete a List from the DB based on listID
	 * @param listID	The listID
	 * @return	status of the delete attempt.
	 */
	@RequestMapping(value="/{listID}",
		method=RequestMethod.DELETE)
	public StatusDTO deleteList(@PathVariable("listID") long listID){
		listService.deleteList(listID);
		StatusDTO status = new StatusDTO();
		status.setMessage("List Deleted Successfully");
		status.setStatus(200);
		return status;
	}
	
	// -------- List Items --------- //
	/**
	 * Get's the list items in a list based on a listID
	 * @param	listID
	 * @return	The list of ListItems
	 */
	@RequestMapping(value="/{listID}/listitems",method=RequestMethod.GET)
	public java.util.List<ListItem> getAllListItemsInList(@PathVariable("listID") long listID) {
		System.out.println("attempting to retrieve listItems");
		List list = listService.getList(listID);
		return listItemService.getListItems(list);
	}
	
	@RequestMapping(value="/listitems/{itemID}",method=RequestMethod.GET)
	public ListItem listItem(@PathVariable("itemID") long itemID) {
		System.out.println("attempting to retrieve listItem");
		System.out.println(listItemService.getListItem(itemID));
		return listItemService.getListItem(itemID);
	}
	
	@RequestMapping(value="/{listID}",method=RequestMethod.POST)
	public String addListItem(@RequestBody ListItem item, @PathVariable("listID") long listID) {
		System.out.println(listID);
		List list = listService.getList(listID);
		System.out.println(list.toString());
		listItemService.addListItem(list, item);
		return item.toString();
	}
	
	@RequestMapping(value="/listitems/{itemID}",method=RequestMethod.DELETE)
	public StatusDTO deleteItem(@PathVariable("itemID") long itemID) {
		listItemService.deleteListItem(itemID);
		StatusDTO status = new StatusDTO();
		status.setMessage("ListItem Deleted Successfully");
		status.setStatus(200);
		return status;
	}
	
	@RequestMapping(value="/{listID}/listitems",method=RequestMethod.PATCH)
	public ListItem editList(@RequestBody ListItem listItem, @PathVariable("listID") long listID){
		List list = listService.getList(listID);
		listItem.setList(list);
		listItem = listItemService.updateListItem(listItem);
		return listItem; 
	}
}
