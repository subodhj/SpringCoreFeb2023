package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeeker;
import com.nt.repo.IJobSeekerRepo;

@Service("jpmService")
public class JobPortalMgmtServiceImpl implements IJobPortalMgmtService {

	@Autowired
	private IJobSeekerRepo repo;

	@Override
	public String registerJobSeeker(JobSeeker seeker) {
		return "JobSeeker info registered with RegNo: " + repo.save(seeker).getRegNo();
	}

	@Override
	public Optional<JobSeeker> searchJobSeeker(long regNo) {
		return repo.findById(regNo);
	}

	@Override
	public List<JobSeeker> searchJobSeeker() {
		return repo.findAll();
	}

}// class
