package com.SecurityLearning;

import com.SecurityLearning.Models.ApplicationUser;
import com.SecurityLearning.Models.Role;
import com.SecurityLearning.Repository.RoleRepository;
import com.SecurityLearning.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SecurityLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityLearningApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roleSet = new HashSet<>();
			roleSet.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1, "admin", passwordEncoder.encode("password"), roleSet);
			userRepository.save(admin);
		};
	}
}
