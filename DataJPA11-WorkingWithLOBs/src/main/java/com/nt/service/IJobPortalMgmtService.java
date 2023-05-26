
package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.JobSeeker;

public interface IJobPortalMgmtService {

	String registerJobSeeker(JobSeeker seeker);

	Optional<JobSeeker> searchJobSeeker(long regNo);

	List<JobSeeker> searchJobSeeker();

}
