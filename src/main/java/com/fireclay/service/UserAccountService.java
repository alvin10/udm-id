/**
 * 
 */
package com.fireclay.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.fireclay.domain.UserAccount;
import com.fireclay.repository.UserAccountRepository;

/**
 * @author Franklin Chua
 *
 */
@Service
public class UserAccountService extends BaseService<UserAccount, UserAccountRepository> {

	public List<UserAccount> find(String name) {
		return getRepository().findByNameContaining(name);
	}
	
	public UserAccount findByUsername(String username) {
		return getRepository().findByUsername(username);
	}
	
	public UserAccount save(UserAccount userAccount, String password) {
		if (userAccount.getSalt() == null) {
			userAccount.setSalt(RandomStringUtils.randomAlphanumeric(16));
		}
		if (password != null) {
			userAccount.setPasswordHash(DigestUtils.sha512Hex(password + userAccount.getSalt()));
		}
		return getRepository().save(userAccount);
	}
}
