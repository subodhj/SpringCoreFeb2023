package com.nt.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.JobSeeker;
import com.nt.service.IJobPortalMgmtService;

@Component
public class LOBsTestRunner implements CommandLineRunner {

	@Autowired
	private IJobPortalMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		try {

			// 1. Register JobSeeker info.
//			System.out.println(service.registerJobSeeker(getJobSeekerInfo()));

			// 2. Search JobSeeker by regNo.
			/*service.searchJobSeeker(52).ifPresentOrElse(js -> {
				System.out.println("RegNo: " + js.getRegNo() + ", Name: " + js.getName() + ", Address: " + js.getAddrs()
						+ ", DOB: " + js.getDob() + ", Indian National: " + js.isIndianNational());
			}, () -> System.out.println("Record not found."));*/

			// 3. Search all JobSeekers.
			/*service.searchJobSeeker().forEach(js -> {
				System.out.println("RegNo: " + js.getRegNo() + ", Name: " + js.getName() + ", Address: " + js.getAddrs()
						+ ", DOB: " + js.getDob() + ", Indian National: " + js.isIndianNational());
			});*/

		} catch (DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("----------dae----------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------e----------");
		}

	}// run(-)

	private JobSeeker getJobSeekerInfo() throws Exception {
		// Collect details of JobSeeker.
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Name: ");
		String name = scan.nextLine();
		System.out.println("Enter DOB (DD-MM-YYYY) : ");
		String dob = scan.next();
		scan.nextLine();
		System.out.println("Enter Addrs: ");
		String addrs = scan.nextLine();
		System.out.println("Enter photo file name with complete path: ");
		String photoPath = scan.next();
		System.out.println("Enter resume file name with complete path: ");
		String resumePath = scan.next();
		System.out.println("Are you an Indian National(true/false): ");
		boolean isIndianNational = scan.nextBoolean();

		// Create JobSeeker object.
		JobSeeker jobSeeker = new JobSeeker(name, formatStringDate(dob), addrs, createPhotoContent(photoPath),
				createResumeContent(resumePath), isIndianNational);
		return jobSeeker;
	}

	private LocalDate formatStringDate(String date) {
		// Create LocalDate object.
		int year = Integer.parseInt(date.substring(6));
		int dayOfMonth = Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(3, 5));
//		Month monthObj = Month.of(month);
		return LocalDate.of(year, month, dayOfMonth);
	}

	private byte[] createPhotoContent(String photoPath) throws Exception {
		// Create byte array representing photo file content.
		InputStream is = new FileInputStream(photoPath);
		byte[] photoContent = new byte[is.available()];
		photoContent = is.readAllBytes();
		return photoContent;
	}

	private char[] createResumeContent(String resumePath) throws Exception {
		// Create character array representing resume file content.
		File file = new File(resumePath);
		Reader reader = new FileReader(file);
		char[] resumeContent = new char[(int) file.length()];
		reader.read(resumeContent);
		return resumeContent;
	}

}// class
