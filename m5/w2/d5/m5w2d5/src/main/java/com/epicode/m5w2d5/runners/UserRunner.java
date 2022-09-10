package com.epicode.m5w2d5.runners;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.epicode.m5w2d5.auth.roles.ERole;
import com.epicode.m5w2d5.auth.roles.Role;
import com.epicode.m5w2d5.auth.roles.RoleRepository;
import com.epicode.m5w2d5.auth.users.User;
import com.epicode.m5w2d5.auth.users.UserRepository;
import com.epicode.m5w2d5.services.DeviceService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Order(1)
@Slf4j
@AllArgsConstructor
public class UserRunner implements ApplicationRunner {
	private RoleRepository roleRepository;
	private UserRepository userRepository;
	private PasswordEncoder encoder;
	private DeviceService deviceSrv;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("===== FIRST RUNNER =====");
		
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);

		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);

		Set<Role> ruoliAmministratore = new HashSet<Role>();
		ruoliAmministratore.add(admin);

		User userAdmin = new User();
		userAdmin.setUsername("admin");
		userAdmin.setName("Ugo");
		userAdmin.setSurname("Ughi");
		userAdmin.setEmail("admin@admin.it");
		userAdmin.setPassword(encoder.encode("111111"));
		userAdmin.setRoles(ruoliAmministratore);
		userRepository.save(userAdmin);

		Set<Role> ruoliUtente = new HashSet<Role>();
		ruoliUtente.add(user);

		User simpleUser = new User();

		simpleUser.setUsername("gianluigi");
		simpleUser.setName("gian");
		simpleUser.setSurname("luigi");
		simpleUser.setEmail("john@gmail.com");
		simpleUser.setPassword(encoder.encode("222222"));
		simpleUser.setRoles(ruoliUtente);
		userRepository.save(simpleUser);
	}

}
