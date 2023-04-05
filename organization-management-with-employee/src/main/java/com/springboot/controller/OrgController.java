package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.dto.OrganizationDto;
import com.springboot.entity.OrganizationBO;
import com.springboot.serviceImpl.OrganizationServiceImpl;

@Controller
public class OrgController {
	
	@Autowired
	OrganizationServiceImpl organizationService;

	@GetMapping("/organization-list")
	public String allOrganization(Model model) {
		model.addAttribute("organizations", organizationService.getAllOrganization());
		return "organization-list";
	}

	@GetMapping("/organization/new")
	public String createOrganizationForm(Model model) {

		OrganizationBO organizationBO = new OrganizationBO();
		model.addAttribute("organization", organizationBO);
		return "create-organization";

	}

	@PostMapping("/organization")
	public String saveOrganization(@ModelAttribute("organization") OrganizationDto organizationDto) {
		organizationService.createOrganization(organizationDto);
		return "redirect:/organization-list";
	}

	@GetMapping("/organization/edit/{id}")
	public String editOrganizationForm(@PathVariable String id, Model model) throws Exception {
		model.addAttribute("organization", organizationService.getOrganizationById(id));
		return "edit-organization";
	}

	@PostMapping("/organization/{id}")
	public String updateOrganization(@PathVariable String id, @ModelAttribute("organization") OrganizationDto organizationDto,
			Model model) throws Exception {

		OrganizationDto existingOrganization = organizationService.getOrganizationById(id);

		existingOrganization.setoID(Long.parseLong(id));
		existingOrganization.setName(organizationDto.getName());
		existingOrganization.setAddress(organizationDto.getAddress());
		existingOrganization.setContactNo(organizationDto.getContactNo());
		existingOrganization.setOwnerName(organizationDto.getOwnerName());

		organizationService.editOrganization(existingOrganization);
		return "redirect:/organization-list";
	}

	@GetMapping("/organization/{id}")
	public String deleteOrganization(@PathVariable String id) {
		organizationService.deleteOrganization(id);
		return "redirect:/organization-list";
	}

}
