package com.proplant.backend;

import java.util.stream.Stream;

import com.proplant.backend.domaines.account.repository.entity.AppRole;
import com.proplant.backend.domaines.account.repository.entity.Admin;
import com.proplant.backend.domaines.account.service.AccountService;
import com.proplant.backend.domaines.archive.repository.dao.ArchiveRepository;
import com.proplant.backend.domaines.archive.repository.entity.Archive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication
public class BackendApplication implements CommandLineRunner{
  
	@Autowired
	private ArchiveRepository archiveRepository;
	@Autowired
	private AccountService accountService;
	
	
		public static void main(String[] args) {
			SpringApplication.run(BackendApplication.class, args);
		}
	
		@Bean
		public BCryptPasswordEncoder getBCPE(){
			return new BCryptPasswordEncoder();
		}
	
	   @Override
	   public void run(String... args) throws Exception{
	   
	   accountService.deleteAdmins();   
	   accountService.saveAdmin(new Admin(null,"admin","Tchoufa","joelnkouatchet@gmail.com","1234","15S20390",null));
	   accountService.saveAdmin(new Admin(null,"user","Tchoufa","joelnkouatchet@gmail.com","1234","118S4520",null));
	
	   accountService.deleteRoles();
	   accountService.saveRole(new AppRole(null,"ADMIN",null));
	   accountService.saveRole(new AppRole(null,"USER",null));
	
	   accountService.addRoleToAdmin("admin", "ADMIN");
	   accountService.addRoleToAdmin("user", "USER");
		   
		  //archiveRepository.deleteAll();
		  Stream.of("archive 1","archive 2","archive 3").forEach(t->{
			  archiveRepository.save(new Archive(null, t, t, null, null, t));
		  }); 
	
			  archiveRepository.findAll().forEach(t->{
				System.out.println(t.getName());
				
			});
		}
	
	}
	
