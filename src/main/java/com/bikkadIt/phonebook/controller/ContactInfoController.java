package com.bikkadIt.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bikkadIt.phonebook.entity.Contact;
import com.bikkadIt.phonebook.service.ContactServiceImpl;

@Controller
public class ContactInfoController {

	@Autowired
	private ContactServiceImpl contactServiceImpl;
	
	@GetMapping("/saveNewContact")
	public String saveNewContact(Model model)
	{
		Contact contactObj=new Contact();
		model.addAttribute("contact",contactObj);
		return "saveContact";
		
	}
	
	@PostMapping("/saveContact")
	public String saveContact(Contact contact, Model model)
	{
		boolean save=contactServiceImpl.saveContact(contact);
		if(save)
		{
			model.addAttribute("success","Your data saves successfully");
		}
		else
		{
			model.addAttribute("error", "Sorry your data not saved");
		}
		return "saveContact";
		
	}
	
	@GetMapping("/getAllContact")
	public String getAllContact(Model model)
	{
		List<Contact> contactList=contactServiceImpl.getAllContacts();
			model.addAttribute("contacts", contactList);
			return "viewAllContacts";
		
	}
	
	@GetMapping("/getContact")
	public String getContact(@RequestParam("cid") Integer contactId, Model model)
	{
		Contact contact=contactServiceImpl.getContactById(contactId);
		if(contact!=null)
		{
			model.addAttribute("contact",contact);
		}
		else
		{
			model.addAttribute("noContact", "Sorry No Match Found");
		}
		return "viewContact";
	}
	
	
}
