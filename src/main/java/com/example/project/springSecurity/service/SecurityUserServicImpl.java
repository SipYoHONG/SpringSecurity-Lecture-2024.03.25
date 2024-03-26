package com.example.project.springSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.springSecurity.dao.SecurityUserDao;
import com.example.project.springSecurity.entity.SecurityUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecurityUserServicImpl implements SecurityUserService{
//	private SecurityUserDao securityDao;
//	@Autowired 
//	public SecurityUserServicImpl(SecurityUserDao securityDao) {
//		this.securityDao = securityDao;
//	}
	private final SecurityUserDao securityDao;		// final만 붙이면 rombok을 이용해서 만들기 쉬움~

	@Override
	public SecurityUser getUserByUid(String uid) {
		return securityDao.getUserByUid(uid);
	}

	@Override
	public List<SecurityUser> getSecurityUserList(int page) {
		int count = COUNT_PER_PAGE;
		int offset = (page - 1) * COUNT_PER_PAGE;
		return securityDao.getSecurityUserList(count, offset);
	}

	@Override
	public int getSecurityUserCount() {
		return securityDao.getSecurityUserCount();
	}

	@Override
	public void insertSecurityUser(SecurityUser securityUser) {
		securityDao.insertSecurityUser(securityUser);
	}

	@Override
	public void updateSecurityUser(SecurityUser securityUser) {
		securityDao.updateSecurityUser(securityUser);
	}

	@Override
	public void deleteSecurityUser(String uid) {
		securityDao.deleteSecurityUser(uid);
	}
}
