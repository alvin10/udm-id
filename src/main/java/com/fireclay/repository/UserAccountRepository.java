/**
 * 
 */
package com.fireclay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fireclay.domain.UserAccount;

/**
 * @author Franklin Chua
 *
 */
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

	List<UserAccount> findByNameContaining(String name);
	
	UserAccount findByUsername(String username);

}
