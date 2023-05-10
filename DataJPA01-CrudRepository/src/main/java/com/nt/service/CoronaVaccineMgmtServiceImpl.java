package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;

@Service("cvmService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo coronaVaccineRepo;

	@Override
	public String registerCoronaVaccine(CoronaVaccine coronaVaccine) { // <S extends T> S save(S entity);
		System.out.println("InMemory Proxy Class : " + coronaVaccineRepo.getClass());
		CoronaVaccine savedCoronaVaccine = null;
		if (coronaVaccine != null)
			savedCoronaVaccine = coronaVaccineRepo.save(coronaVaccine);
		return savedCoronaVaccine != null
				? "Vaccine registered/Updated successfully with Registration No: " + savedCoronaVaccine.getRegNo()
				: "Vaccine registration/Updation failed.";
	}

	// <S extends T> Iterable<S> saveAll(Iterable<S> entities);
	@Override
	public void registerCoronaVaccinesInBatch(Iterable<CoronaVaccine> coronaVaccines) {
		Iterable<CoronaVaccine> savedCoronaVaccines = null;
		if (coronaVaccines != null) {
			savedCoronaVaccines = coronaVaccineRepo.saveAll(coronaVaccines);
			if (savedCoronaVaccines != null)
				savedCoronaVaccines.forEach(coronaVaccine -> System.out
						.println("Vaccine registered successfully with Registration No:" + coronaVaccine.getRegNo()));
			else
				System.out.println("No Corona Vaccines Available.");
		} else
			throw new IllegalArgumentException("Batch/Bulk Insertion Failed.");

	}

	@Override
	public String getCoronaVaccinesCount() { // long count();
		long count = 0;
		count = coronaVaccineRepo.count();
		return count <= 0 ? "No Corona Vaccines Available." : "Corona Vaccines Available are: " + count;

		/*return coronaVaccineRepo.count() <= 0 ? "No Corona Vaccines Available."
				: "Corona Vaccines Available are: " + count;*/
	}

	@Override
	public String checkCoronaVaccineAvailability(Long regNo) { // boolean existsById(ID id);
		/*boolean isAvailable = false;
		isAvailable = coronaVaccineRepo.existsById(regNo);
		if (isAvailable)
			return "Corona Vaccine with RegNo:" + regNo + " is available.";
		else
			return "Corona Vaccine with RegNo:" + regNo + " is not available.";*/

		/*if (coronaVaccineRepo.existsById(regNo))
			return "Corona Vaccine with RegNo:" + regNo + " is available.";
		else
			return "Corona Vaccine with RegNo:" + regNo + " is not available.";*/

		return coronaVaccineRepo.existsById(regNo) ? "Corona Vaccine with RegNo:" + regNo + " is available."
				: "Corona Vaccine with RegNo:" + regNo + " is not available.";
	}

	@Override
	public void searchAllCoronaVaccines() { // Iterable<T> findAll();
		Iterable<CoronaVaccine> coronaVaccines = null;
//		coronaVaccines = coronaVaccineRepo.findAll();
//		if (coronaVaccines != null) // Dead Code as else block executes. Hence commented.
//			coronaVaccines.forEach(coronaVaccine->System.out.println(coronaVaccine));
//			coronaVaccines.forEach(System.out::println);
//			coronaVaccineRepo.findAll().forEach(System.out::println);
//		coronaVaccineRepo.findAll().forEach(System.out::println);
		/*Arrays.asList(coronaVaccines).stream().forEach(coronaVaccine -> {
			System.out.print(coronaVaccine);
		});*/
//			Arrays.asList(coronaVaccines).stream().forEach(System.out::println);
//		else
//			System.out.println("No Corona Vaccines Available.");
	}

	// Iterable<T> findAllById(Iterable<ID> ids);
	@Override
	public void searchAllCoronaVaccinesById(Iterable<Long> ids) {
		/*Iterable<CoronaVaccine> coronaVaccines = null;
		coronaVaccines = coronaVaccineRepo.findAllById(ids);
		if (coronaVaccines != null)
			Arrays.asList(coronaVaccines).stream().forEach(System.out::println);
		else
			System.out.println("No Corona Vaccines Available.");*/

//		coronaVaccineRepo.findAllById(ids).forEach(coronaVaccine -> System.out.println(coronaVaccine));
//		coronaVaccineRepo.findAllById(ids).forEach(System.out::println);
//		Arrays.asList(coronaVaccineRepo.findAllById(ids)).stream().forEach(System.out::println);
//		Arrays.asList(coronaVaccineRepo.findAllById(ids)).stream().map(vac1 -> vac1).forEach(System.out::println);
//		Arrays.asList(coronaVaccineRepo.findAllById(ids)).stream().map(vac1->{vac1.forEach(cv->cv.getCountry().equals("Russia"));}).forEach(System.out::println);
	}

	@Override
	public void searchCoronaVaccineById(Long id) { // Optional<T> findById(ID id);
		/*Optional<CoronaVaccine> optional = null;
		optional = coronaVaccineRepo.findById(id);
		if (optional.isPresent())
			System.out.println(optional.get());
		else
			System.out.println("Corona Vaccine with RegNo:" + id + " is not available.");*/

		/*System.out.println(coronaVaccineRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Corona Vaccine with regNo:" + id + " not found.")));*/
//		System.out.println(coronaVaccineRepo.findById(id).orElse(new CoronaVaccine()));
//		System.out.println(coronaVaccineRepo.findById(id).orElseGet(()->new CoronaVaccine()));
		coronaVaccineRepo.findById(id).ifPresentOrElse(System.out::println,
				() -> System.out.println("Corona Vaccine with regNo:" + id + " not found."));
	}

	@Override
	public void deleteCoronaVaccineById(Long id) { // void deleteById(ID id);
		coronaVaccineRepo.findById(id).ifPresentOrElse(coronaVaccine -> {
			coronaVaccineRepo.deleteById(id);
			System.out.println("Corona Vaccine with regNo:" + id + " is deleted.");
		}, () -> System.out.println("Corona Vaccine with regNo:" + id + " is not deleted as it is not available."));
	}

	@Override
	public String removeCoronaVaccineById(Long id) { // void deleteById(ID id);
		Optional<CoronaVaccine> optional = null;
		optional = coronaVaccineRepo.findById(id);
		if (optional.isPresent()) {
			coronaVaccineRepo.deleteById(id);
			return "Corona Vaccine with regNo:" + id + " is deleted.";
		}
		return "Corona Vaccine with regNo:" + id + " is not deleted as it is not available.";
	}

	@Override
	public String removeCoronaVaccineByEntity(CoronaVaccine coronaVaccine) { // void delete(T entity);
		Long id = 0L;
		id = coronaVaccine.getRegNo();

		/*if (coronaVaccineRepo.existsById(id)) {
			coronaVaccineRepo.delete(coronaVaccine);
			return "Corona Vaccine with regNo: " + id + " is deleted.";
		}
		return "Corona Vaccine with regNo: " + id + " is not deleted as it is not available.";*/

		Optional<CoronaVaccine> optional = coronaVaccineRepo.findById(id);
		/*optional.ifPresentOrElse(coronaVaccine -> {
			                                        coronaVaccineRepo.delete(coronaVaccine);
			                                        return "Corona Vaccine with regNo: " + id + " is deleted.";
		
		                                          }, 
				                 ()->{
				                	   return "Corona Vaccine with regNo: " + id + " is not deleted as it is not available.";
				                	 }
				                );*/
		if (optional.isPresent()) {
			coronaVaccineRepo.delete(coronaVaccine);
			return "Corona Vaccine with regNo: " + id + " is deleted.";
		}
		return "Corona Vaccine with regNo: " + id + " is not deleted as it is not available.";
	}

	@Override
	public String removeAllCoronaVaccinesById(Iterable<Long> ids) { // void deleteAllById(Iterable<? extends ID> ids);
		/*int count = ((List) coronaVaccineRepo.findAllById(ids)).size();
		coronaVaccineRepo.deleteAllById(ids);
		return count + " Corona Vaccines were deleted.";*/

		int givenIDsCount = ((List) ids).size();

		List<CoronaVaccine> coronaVaccines = ((List) coronaVaccineRepo.findAllById(ids));
		int availableIDsCount = coronaVaccines.size();

		if (availableIDsCount == givenIDsCount) {
			coronaVaccineRepo.deleteAllById(ids);
			return "Given " + availableIDsCount + " Corona Vaccines were deleted.";
		} else {
			List<Long> givenIDsList = new ArrayList<>(givenIDsCount);
			givenIDsList.addAll((Collection) ids);

			List<Long> availableIDsList = new ArrayList<>(availableIDsCount);
			coronaVaccines.forEach(coronaVaccine -> {
				availableIDsList.add(coronaVaccine.getRegNo());
			});
			givenIDsList.removeAll(availableIDsList);
			return "Corona Vaccines were not deleted as " + (givenIDsCount - availableIDsCount)
					+ " were not available. They are " + givenIDsList.toString();
		}
	}

	// void deleteAll(Iterable<? extends T> entities);
	@Override
	public String removeAllCoronaVaccines(Iterable<CoronaVaccine> entities) {
		List<Long> givenEntitiesIDs = new ArrayList<>();
		entities.forEach(coronaVaccine -> givenEntitiesIDs.add(coronaVaccine.getRegNo()));
		int givenEntitiesCount = givenEntitiesIDs.size();

		List<CoronaVaccine> availableEntities = (List) coronaVaccineRepo.findAllById(givenEntitiesIDs);
		int availableEntitiesCount = availableEntities.size();

		if (givenEntitiesCount == availableEntitiesCount) {
			coronaVaccineRepo.deleteAll(entities);
			return "Given " + givenEntitiesCount + " Corona Vaccines were deleted.";
		} else {
			List<Long> availableEntitiesIDs = new ArrayList<>(availableEntitiesCount);
			availableEntities.forEach(coronaVaccine -> availableEntitiesIDs.add(coronaVaccine.getRegNo()));
			givenEntitiesIDs.removeAll(availableEntitiesIDs);

			return "Corona Vaccines were not deleted as " + (givenEntitiesCount - availableEntitiesCount)
					+ " were not available. They were " + givenEntitiesIDs.toString();
		}
	}

	@Override
	public String removeAllCoronaVaccines() { // void deleteAll();
		Long count = 0L;
		count = coronaVaccineRepo.count();
		if (count > 0) {
			coronaVaccineRepo.deleteAll();
			return "All " + count + " Corona Vaccines were deleted.";
		}
		return "No Corona Vaccines were available for deletion.";

	}

} // class
