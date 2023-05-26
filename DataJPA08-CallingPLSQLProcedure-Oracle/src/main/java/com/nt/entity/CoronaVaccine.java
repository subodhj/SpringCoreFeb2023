package com.nt.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NamedStoredProcedureQuery(name = "CoronaVaccine.getVaccinesByPriceRange", 
                                                    procedureName = "P_GET_VACCINES_BY_PRICERANGE", 
                                                    parameters = {
																			@StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class),
																			@StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class),
																			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = CoronaVaccine.class) 
		                                                                   },
                                                    resultClasses = CoronaVaccine.class
                                                    )
/*@NamedStoredProcedureQuery(name = "CoronaVaccine.getVaccinesByPriceRange", 
                                                	procedureName = "P_GET_VACCINES_BY_PRICERANGE", 
                                                	parameters = {
										@StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "STARTPRICE"),
										@StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "ENDPRICE"),
										@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = CoronaVaccine.class, name = "DETAILS") 
                       													  },
                                                	resultClasses = CoronaVaccine.class
													)*/
@Data
//@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
//@Table(name = "CORONA_VACCINE_TAB")
public class CoronaVaccine implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long regNo;
	@NonNull
	@Column(length = 20)
	private String name;
	@NonNull
	@Column(length = 20)
	private String company;
	@NonNull
	@Column(length = 20)
	private String country;
	@NonNull
	private Double price;
	@NonNull
	private Integer doses;

}
