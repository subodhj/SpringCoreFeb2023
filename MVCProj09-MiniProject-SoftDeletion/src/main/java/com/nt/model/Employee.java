package com.nt.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "emp_data")
@SQLDelete(sql = "UPDATE emp_data SET status='Deleted' WHERE empno=?")
@Where(clause = "STATUS <> 'Deleted' ")
@Data
public class Employee {

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "empno_seq1", initialValue = 3000, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	private Integer deptno = 10;
	private String status = "Active";

}
