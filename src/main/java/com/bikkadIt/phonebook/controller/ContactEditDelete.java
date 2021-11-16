package com.bikkadIt.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bikkadIt.phonebook.entity.Contact;
import com.bikkadIt.phonebook.service.ContactServiceImpl;
@Controller
public class ContactEditDelete {
	
	
	@Autowired
	private ContactServiceImpl contactServiceImpl;
	
	@GetMapping("/updateContact")
	public String updateContact(@RequestParam("cid") Integer contactId,Model model)
	{
		Contact contact=contactServiceImpl.getContactById(contactId);
		System.out.println(contact);
		model.addAttribute("contact", contact);
		return "saveContact";
	}
	
	
	
	@GetMapping("/deleteContacts")
	public String deleteContact(@RequestParam("cid") Integer contactId, Model model)
	{
		contactServiceImpl.deleteContactById(contactId);
		return "redirect:getAllContact";
	}

}
