package com.loicdev.springdemo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.loicdev.springdemo.domain.Role;
import com.loicdev.springdemo.domain.RoleName;
import com.loicdev.springdemo.repository.RoleRepository;

@Component
@Profile({"dev", "test", "prod"})
public class BootstrapData implements CommandLineRunner {

	RoleRepository roleRepository;
	
	public BootstrapData(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		loadRoles();
	}

	private void loadRoles() {
		Role userRole = new Role();
		userRole.setName(RoleName.ROLE_USER);
		roleRepository.save(userRole);
		
		Role adminRole = new Role();
		adminRole.setName(RoleName.ROLE_ADMIN);
		roleRepository.save(adminRole);
	}

}
