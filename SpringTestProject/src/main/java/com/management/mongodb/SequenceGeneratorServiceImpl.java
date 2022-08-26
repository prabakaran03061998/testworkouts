package com.management.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.dao.UsersRepositoryImpl;
import com.management.model.Users;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SequenceGeneratorServiceImpl implements SequenceGeneratorService {
	@Autowired
	private UsersRepositoryImpl userRespositorImpl;

	@Override
	public long getNextSequenceOfUser(String seqName) {
		log.debug("getNextSequence");
		Users last = userRespositorImpl.findTopByOrderByIdDesc();
		if (last != null) {
			long lastNum = last.getId();
			return lastNum + 1;
		}
		return 1;
	}
}
