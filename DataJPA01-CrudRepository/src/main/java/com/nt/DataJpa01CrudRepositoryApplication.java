package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.entity.CoronaVaccine;
import com.nt.service.ICoronaVaccineMgmtService;

@SpringBootApplication // (exclude = DataSourceAutoConfiguration.class)
public class DataJpa01CrudRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpa01CrudRepositoryApplication.class, args);
		/*ApplicationContext ctx = null;
		ICoronaVaccineMgmtService service = null;
		CoronaVaccine coronaVaccine = null;
		
		// Access IOC container.
		ctx = SpringApplication.run(DataJpa01CrudRepositoryApplication.class, args);
		
		// Access service class object.
		//		service = ctx.getBean("cvmService", CoronaVaccineMgmtServiceImpl.class);
		service = ctx.getBean("cvmService", ICoronaVaccineMgmtService.class);
		try {
			// Create entity class object.
		//			coronaVaccine = new CoronaVaccine(5L, "Covaxin25.0", "BharatBiotech", "India", 700.0, 2);
		//			coronaVaccine = new CoronaVaccine(null, "Covaxin25.0", "BharatBiotech", "India", 700.0, 2);
			coronaVaccine = new CoronaVaccine("Covaxin", "BharatBiotech", "India", 700.0, 2);
		
			// Invoke b.logic.
			System.out.println(service.registerCoronaVaccine(coronaVaccine));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close IOC container
			((AbstractApplicationContext) ctx).close();
		}*/
	}// main(-)

}// class
