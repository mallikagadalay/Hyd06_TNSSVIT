package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
 AdminService adminService;
	
	@PostMapping("/admin")
	public Admin saveAdmin(@RequestBody Admin admin)
	{
		return adminService.saveAdmin(admin);
	}
	
	@GetMapping("/admin")
	public List<Admin> fetchAdminList()
	{
		return adminService.fetchAdminList();
	}
	
	// Get by ID
	@GetMapping("/admin/{id}")
	public Admin fetchAdminById(@PathVariable("id") Long id)
	{
		return adminService.fetchAdminById(id);
	}
	
	@DeleteMapping("/admin/{id}")
	public String deleteAdminById(@PathVariable("id") Long id)
	{
		adminService.deleteAdminById(id);
		return "Admin deleted Successfully !!";
	}
	
	@PutMapping("/admin/{id}")
	public Admin updateAdmin(@PathVariable("id") Long id,@RequestBody Admin admin)
	{
		return adminService.updateAdmin(id,admin);
	}

}
