package com.ing.service;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.dto.RegisterRequestDTO;
import com.ing.dto.RegisterResponseDTO;
import com.ing.util.MailWithOTPService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RegisterServiceImplTest {

	@Mock
	MailWithOTPService api;

	@InjectMocks
	RegisterServiceImpl mailService;
	
	RegisterRequestDTO registerRequestDTO = null;
	RegisterResponseDTO registerResponseDTO = null;
	
	@Before
	public void setUp() {
		registerRequestDTO  = new RegisterRequestDTO();
		registerRequestDTO.setDeposit(100);
		registerRequestDTO.setDob(LocalDate.now());
		registerRequestDTO.setEmail("dhanashekara123@gmail.com");
		registerRequestDTO.setFirstName("sdhagsd");
		registerRequestDTO.setLastName("lastname");
		registerRequestDTO.setMobile("1212121212");
		registerRequestDTO.setOccupation("SE");
		registerRequestDTO.setPropertyCost(10000);
		
		registerResponseDTO = new RegisterResponseDTO();
		registerResponseDTO.setCustomerId("as1212");
		registerResponseDTO.setMessage("Success");
		registerResponseDTO.setMortgageAcc("MORT1212");
		registerResponseDTO.setPassword("Pass1212");
		registerResponseDTO.setStatus("SUCCESS");
		registerResponseDTO.setStatusCode(201);
		registerResponseDTO.setTransactionAcc("TR11212");
	}

	@Test
	public void testGenerateOTPandSendMail() {
		
		Mockito.doNothing().when(api).sendEmail("dhanashekara123@gmail.com","ING Transactions","OTP for abc");
		String actual = mailService.generateOTPandSendMail("dhanashekara123@gmail.com");
		assertEquals("SUCCESS", actual);
		
	}
	
	@Test(expected = Exception.class)
	public void exceptionTest() throws Exception {
		
		Mockito.doNothing().when(api).sendEmail("dhanashekara123@gmail.com","ING Transactions","OTP for abc");
		mailService.generateOTPandSendMail("abc");
		throw new Exception("");
	}
	
	@Test
	public void testRegisterCustomer() {
		
		
		
	}
}
