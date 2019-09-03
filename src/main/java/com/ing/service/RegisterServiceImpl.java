package com.ing.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.dto.RegisterRequestDTO;
import com.ing.dto.RegisterResponseDTO;
import com.ing.entity.Account;
import com.ing.entity.Customer;
import com.ing.entity.Mortagage;
import com.ing.exception.MortagageManagementException;
import com.ing.repository.AccountRepository;
import com.ing.repository.CustomerRepository;
import com.ing.repository.MortagageRepository;

/***
 * 
 * @author Pradeep
 * method to create customer, account and mortgage 
 *@param  RegisterRequestDTO
 *@retun RegisterResponseDTO
 *@exception MortagageManagementException
 */

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private MortagageRepository mortagageRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public RegisterResponseDTO registerCustomer(RegisterRequestDTO requestDTO) {

		LocalDate today = LocalDate.now();
		Period period = Period.between(requestDTO.getDob(), today);
		if (period.getYears() < 18)
			throw new MortagageManagementException("Sorry we are unable to grant you the mortgage at this moment");
		
		Random rand = new Random();
		String customerIdPrefix = "ING";
		int n = rand.nextInt(99999);
		String customerId = customerIdPrefix + new Integer(n).toString();
		int m = rand.nextInt(999999);
		String mortgageIdPrefix = "MORT";
		String mortgageId = mortgageIdPrefix + new Integer(m).toString();
		String password = requestDTO.getFirstName() + "@" + requestDTO.getDob().getYear();
		int o = rand.nextInt(9999);
		String accountIdIdPrefix = "MAGGIE";
		String accountId = accountIdIdPrefix + new Integer(o).toString();
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setDob(requestDTO.getDob());
		customer.setEmail(requestDTO.getEmail());
		customer.setFirstName(requestDTO.getFirstName());
		customer.setLastName(requestDTO.getLastName());
		customer.setMobile(requestDTO.getMobile());
		customer.setOccupation(requestDTO.getOccupation());
		customer.setPassword(password);
		customerRepository.save(customer);
		
		
		Account account = new Account();
		account.setAccountNumber(accountId);
		account.setBalance(requestDTO.getPropertyCost() - requestDTO.getDeposit());
		account.setCreatedOn(LocalDate.now());
		account.setCustomerId(customer.getCustomerId());
		account.setAccountType("Transaction");
		accountRepository.save(account);
		
		
		Mortagage mortgage = new Mortagage();
		mortgage.setCustomerId(customer.getCustomerId());
		mortgage.setDeposit(requestDTO.getDeposit());
		mortgage.setMortagageId(mortgageId);
		mortgage.setPropertyCost(requestDTO.getPropertyCost());
		mortgage.setMortagageType("Mortgage");
		mortgage.setMortagageBalance(-(requestDTO.getPropertyCost() - requestDTO.getDeposit()));
		mortagageRepository.save(mortgage);
		
		
		RegisterResponseDTO result = new RegisterResponseDTO();
		result.setCustomerId(customer.getCustomerId());
		result.setMessage("Registration Successfull");
		result.setMortgageAcc(mortgage.getMortagageId());
		result.setPassword(password);
		return result;
	}
}
