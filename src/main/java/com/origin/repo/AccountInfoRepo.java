package com.origin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.origin.web.AccountInfo;
@Repository
public interface AccountInfoRepo extends JpaRepository<AccountInfo, Integer>{

}
