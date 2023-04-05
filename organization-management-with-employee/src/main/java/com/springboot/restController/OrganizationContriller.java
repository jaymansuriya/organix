package com.springboot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.OrganizationDto;
import com.springboot.entity.OrganizationBO;
import com.springboot.serviceImpl.OrganizationServiceImpl;

@RestController
public class OrganizationContriller {
	@Autowired
	OrganizationServiceImpl organizationService;

	@GetMapping("/api/organizations")
	public List<OrganizationBO> getOrganizations() {
		return organizationService.getAllOrganization();
	}

	@GetMapping("/api/organizations/{organizationId}")
	public OrganizationDto getOrganization(@PathVariable("organizationId") String id) throws Exception {
		return organizationService.getOrganizationById(id);

	}

	@PostMapping("/api/add-organization")
	public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto) {
		return new ResponseEntity<>(organizationService.createOrganization(organizationDto), HttpStatus.CREATED);

	}

	@PutMapping("/api/update-organization")
	public OrganizationDto updateOrganization(@RequestBody OrganizationDto organizationDto) throws Exception {
		return organizationService.editOrganization(organizationDto);
	}

	@DeleteMapping("/api/delete-organization/{organizationId}")
	public ResponseEntity<?> deleteDepertment(@PathVariable("organizationId") String id) throws Exception {
		
		try {
			return organizationService.deleteOrganization(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
