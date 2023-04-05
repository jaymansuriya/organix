package com.springboot.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.dto.OrganizationDto;
import com.springboot.entity.OrganizationBO;
import com.springboot.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<OrganizationBO> getAllOrganization() {
		return organizationRepository.findAll();
	}

	public OrganizationDto createOrganization(OrganizationDto organizationDto) {

		OrganizationBO organizationBO = modelMapper.map(organizationDto, OrganizationBO.class);

		organizationBO.setName(organizationDto.getName());
		organizationBO.setOwnerName(organizationDto.getOwnerName());
		organizationBO.setAddress(organizationDto.getAddress());
		organizationBO.setContactNo(organizationDto.getContactNo());

		if (organizationRepository.existsByName(organizationDto.getName())) {
			throw new RuntimeException("Organization is already exists");
		}

		organizationRepository.save(organizationBO);

		return modelMapper.map(organizationBO, OrganizationDto.class);
	}

	public OrganizationDto editOrganization(OrganizationDto organizationDto) throws Exception {
		
		if (organizationRepository.existsByName(organizationDto.getName())) {
			throw new RuntimeException("Organization is already exists");
		}
		
		OrganizationBO organizationBO = organizationRepository.findById(organizationDto.getoID())
				.orElseThrow(() -> new Exception("Organization not found with this id::" + organizationDto.getoID()));

		organizationBO.setName(organizationDto.getName());
		organizationBO.setOwnerName(organizationDto.getOwnerName());
		organizationBO.setAddress(organizationDto.getAddress());
		organizationBO.setContactNo(organizationDto.getContactNo());

		organizationRepository.save(organizationBO);

		return modelMapper.map(organizationBO, OrganizationDto.class);
	}

	public OrganizationDto getOrganizationById(String id) throws Exception {
		return modelMapper.map(organizationRepository.findById(Long.parseLong(id))
				.orElseThrow(() -> new Exception("Organization not found with this id::" + id)), OrganizationDto.class);

	}

	public ResponseEntity<?> deleteOrganization(String id) {
		try {
			organizationRepository.deleteById(Long.parseLong(id));
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

	public OrganizationBO getIDByName(String name) {

		OrganizationBO organizationBO = organizationRepository.findByName(name);
		return organizationBO;

	}
}
