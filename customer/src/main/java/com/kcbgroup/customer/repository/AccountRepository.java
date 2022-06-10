package com.kcbgroup.customer.repository;

import com.kcbgroup.customer.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface AccountRepository extends JpaRepository<AccountModel,String> {

}
