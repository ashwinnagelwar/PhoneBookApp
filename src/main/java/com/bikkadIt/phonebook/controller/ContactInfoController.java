package com.bikkadIt.phonebook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bikkadIt.phonebook.entity.Contact;
import com.bikkadIt.phonebook.service.ContactServiceImpl;

@Controller
public class ContactInfoController {

	private ContactServiceImpl contactServiceImpl;
	
	@PostMapping("/saveContact")
	public String saveContact(Contact contact)
	{
		boolean flag=contactServiceImpl.saveContact(contact);
		
		if(flag==true)
		{
			return "Your contact is saved successfully";
		}
		else
		{
			return "Sorry, your contact cant be saved";
		}
	}
	
	@GetMapping("/getAllContact")
	public List<Contact> getAllContact()
	{
		List<Contact> list=contactServiceImpl.getAllContacts();
		
		return list;
		
		
	}
	
	@GetMapping("/getContact/{cid}")
	public Contact getContact(@PathVariable int cid)
	{
		Contact contact=contactServiceImpl.getContactById(cid);
		if(contact!=null)
		{
			return contact;
		}
		return null;
	}
	
	@DeleteMapping("/deletContact/{cid}")
	public String deleteContact(@PathVariable int cid)
	{
		boolean flag=contactServiceImpl.deleteContactById(cid);
		if(flag==true)
		{
			return "Your contact is deleted Successfull";
		}
		else
		{
			return "Your contact is not present in records";
		}
	}
}
