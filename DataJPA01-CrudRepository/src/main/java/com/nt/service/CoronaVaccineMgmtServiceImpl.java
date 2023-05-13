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
		CoronaVaccine savedCoronaVaccine = null;

		// Print InMemory Proxy class name.
		System.out.println("InMemory Proxy Class : " + coronaVaccineRepo.getClass());

		// Invoke Repository method.
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

		// Invoke Repository method.
		if (coronaVaccines != null && !((List) coronaVaccines).isEmpty()) {
			savedCoronaVaccines = coronaVaccineRepo.saveAll(coronaVaccines);
			// Print ID values of all the saved entities.
			if (savedCoronaVaccines != null && ((List) savedCoronaVaccines).size() > 0)
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

		// Invoke Repository method.
		count = coronaVaccineRepo.count();

		return count <= 0 ? "No Corona Vaccines Available." : "Corona Vaccines Available are: " + count;

		/*return coronaVaccineRepo.count() <= 0 ? "No Corona Vaccines Available."
				: "Corona Vaccines Available are: " + count;*/
	}

	@Override
	public String checkCoronaVaccineAvailability(Long regNo) { // boolean existsById(ID id);
		/*boolean isAvailable = false;
		
		//Invoke Repository method.
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

		// Invoke Repository method.
		coronaVaccines = coronaVaccineRepo.findAll();

//		if (coronaVaccines != null) // Dead Code as else block executes. Hence commented.
//			coronaVaccines.forEach(coronaVaccine->System.out.println(coronaVaccine));
//			coronaVaccines.forEach(System.out::println);

//		coronaVaccineRepo.findAll().forEach(System.out::println);

//		coronaVaccineRepo.findAll().forEach(System.out::println);

		/*Arrays.asList(coronaVaccines).stream().forEach(coronaVaccine -> {
			System.out.print(coronaVaccine);
		});*/

		if (!((List) coronaVaccines).isEmpty())
//			Arrays.asList(coronaVaccines).stream().forEach(System.out::println);
			((List) coronaVaccines).stream().forEach(System.out::println);
		else
			System.out.println("No Corona Vaccines Available.");
	}

	// Iterable<T> findAllById(Iterable<ID> ids);
	@Override
	public void searchAllCoronaVaccinesById(Iterable<Long> ids) {
		Iterable<CoronaVaccine> coronaVaccines = null;

		// Invoke Repository method.
		coronaVaccines = coronaVaccineRepo.findAllById(ids);

//		if (coronaVaccines != null)  // []

//		if (((List) coronaVaccines).size() != 0)

		if (!((List) coronaVaccines).isEmpty())
			Arrays.asList(coronaVaccines).stream().forEach(System.out::println);
		else
			System.out.println("No Corona Vaccines Available."); // []

//		coronaVaccineRepo.findAllById(ids).forEach(coronaVaccine -> System.out.println(coronaVaccine));

//		coronaVaccineRepo.findAllById(ids).forEach(System.out::println);

//		Arrays.asList(coronaVaccineRepo.findAllById(ids)).stream().forEach(System.out::println);

//		Arrays.asList(coronaVaccineRepo.findAllById(ids)).stream().map(vac1 -> vac1).forEach(System.out::println);

//		Arrays.asList(coronaVaccineRepo.findAllById(ids)).stream().map(vac1->{vac1.forEach(cv->cv.getCountry().equals("Russia"));}).forEach(System.out::println);
	}

	@Override
	public void searchCoronaVaccineById(Long id) { // Optional<T> findById(ID id);
		/*Optional<CoronaVaccine> optional = null;
		
		// Invoke Repsitory method.
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

		// Invoke Repository method to find availability of the given ID based record.
		optional = coronaVaccineRepo.findById(id);

		// Invoke Repository method.
		if (optional.isPresent()) {
			coronaVaccineRepo.deleteById(id);
			return "Corona Vaccine with regNo:" + id + " is deleted.";
		}

		return "Corona Vaccine with regNo:" + id + " is not deleted as it is not available.";
	}

	@Override
	public String removeCoronaVaccineByEntity(CoronaVaccine coronaVaccine) { // void delete(T entity);
		Long id = 0L;

		// Get ID value of the given Entity.
		id = coronaVaccine.getRegNo();

		// Find the availability of the given Entity based on its ID value.

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

		// Invoke Repository method.
		if (optional.isPresent()) {
			coronaVaccineRepo.delete(coronaVaccine);
			return "Corona Vaccine with regNo: " + id + " is deleted.";
		}
		return "Corona Vaccine with regNo: " + id + " is not deleted as it is not available.";
	}

	@Override
	public String removeAllCoronaVaccinesById(Iterable<Long> ids) { // void deleteAllById(Iterable<? extends ID> ids);

		// Invoke Repository method to find the available entities count based on IDs.
		/*int count = ((List) coronaVaccineRepo.findAllById(ids)).size();
		
		// Invoke Repository method.
		coronaVaccineRepo.deleteAllById(ids);
		
		return count + " Corona Vaccines were deleted.";*/

		// Find size of the given IDs collection.
		int givenIDsCount = ((List) ids).size();

		// Invoke Repository method to get all available records based on their IDs.
		List<CoronaVaccine> coronaVaccines = ((List) coronaVaccineRepo.findAllById(ids));

		// Find count of available records in DB s/w.
		int availableIDsCount = coronaVaccines.size();

		// Invoke Repository method.
		if (availableIDsCount == givenIDsCount) {
			coronaVaccineRepo.deleteAllById(ids);
			return "Given " + availableIDsCount + " Corona Vaccines were deleted.";
		} else {
			// Create a List collection with the initial capacity equal to the size of the
			// given IDs collection.
			List<Long> givenIDsList = new ArrayList<>(givenIDsCount);

			// Add all the ID values from the given IDs collection to the List collection.
			givenIDsList.addAll((Collection) ids);

			// Create a List collection with the initial capacity equal to the count of
			// available records.
			List<Long> availableIDsList = new ArrayList<>(availableIDsCount);

			// Add all the available entities' ID values to the List collection.
			coronaVaccines.forEach(coronaVaccine -> {
				availableIDsList.add(coronaVaccine.getRegNo());
			});

			// Remove those entities/elements from List collection containing given ID
			// values that are also there in the List collection containg available entities
			// IDs.
			givenIDsList.removeAll(availableIDsList);

			return "Corona Vaccines were not deleted as " + (givenIDsCount - availableIDsCount)
					+ " were not available. They are " + givenIDsList.toString();
		}
	}

	// void deleteAll(Iterable<? extends T> entities);
	@Override
	public String removeAllCoronaVaccines(Iterable<CoronaVaccine> entities) {
		int givenEntitiesCount = 0;
		int availableEntitiesCount = 0;

		// Create an empty List collection.
		List<Long> givenEntitiesIDs = new ArrayList<>();

		// Add the ID values of the given entities to List collection.
		entities.forEach(coronaVaccine -> givenEntitiesIDs.add(coronaVaccine.getRegNo()));

		// Get the count of elements that are added to the List collection.
		if (givenEntitiesIDs != null && !givenEntitiesIDs.isEmpty())
			givenEntitiesCount = givenEntitiesIDs.size();

		// Invoke Repository method to get all the available entities based on the given
		// entities IDs.
		List<CoronaVaccine> availableEntities = (List) coronaVaccineRepo.findAllById(givenEntitiesIDs);

		// Find the number of available entities.
		if (availableEntities != null && !availableEntities.isEmpty())
			availableEntitiesCount = availableEntities.size();

		// Invoke Repository method.
		if (givenEntitiesCount == availableEntitiesCount) {
			coronaVaccineRepo.deleteAll(entities);
			return "Given " + givenEntitiesCount + " Corona Vaccines were deleted.";
		} else {
			// Create a List collection with the initial capacity equal to the no. of
			// available entities.
			List<Long> availableEntitiesIDs = new ArrayList<>(availableEntitiesCount);

			// Add ID values of all the available entites to the List collection.
			if (availableEntities != null && availableEntities.size() > 0)
				availableEntities.forEach(coronaVaccine -> availableEntitiesIDs.add(coronaVaccine.getRegNo()));

			// Remove those entities/elements from the List collection containing IDs of
			// given entites that are also there in the List collection containing IDs of
			// available entites.
			givenEntitiesIDs.removeAll(availableEntitiesIDs);

			return "Corona Vaccines were not deleted as " + (givenEntitiesCount - availableEntitiesCount)
					+ " were not available. They were " + givenEntitiesIDs.toString();
		}
	}

	@Override
	public String removeAllCoronaVaccines() { // void deleteAll();
		Long count = 0L;

		// Invoke Repository method to get the count of all the available entities.
		count = coronaVaccineRepo.count();

		// Invoke Repository method.
		if (count > 0) {
			coronaVaccineRepo.deleteAll();
			return "All " + count + " Corona Vaccines were deleted.";
		}

		return "No Corona Vaccines were available for deletion.";

	}

} // class
