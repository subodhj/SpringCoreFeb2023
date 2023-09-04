package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Voter;
import com.nt.repository.IVoterRepo;

@Service("voterMgmtService")
public class VoterMgmtServiceImpl implements IVoterMgmtService {

	@Autowired
	private IVoterRepo voterRepo;

	/*@Override
	public int registerVoter(Voter voter) {
		return voterRepo.save(voter).getVid();
	}*/

	@Override
	public Voter registerVoter(Voter voter) {
		return voterRepo.save(voter);
	}
	
}
