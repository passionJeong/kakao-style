package apiserver.document.approval.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import apiserver.document.approval.dto.GetUserAccountInfoInDto;
import apiserver.document.approval.dto.GetUserAccountInfoOutDto;
import apiserver.document.approval.dto.PostUserAccountInDto;
import apiserver.document.approval.dto.PostUserAccountOutDto;
import apiserver.document.approval.service.GetUserAccountInfoService;
import apiserver.document.approval.service.PostUserAccountService;

/**
 * Login controller
 * @author jeongseoyeon
 * login관련 서비스를 처리한다.
 */

@RestController
public class LoginController {
	
	private final GetUserAccountInfoService getUserAccountInfoService;
	
	private final PostUserAccountService postUserAccountService;
	
	public LoginController(GetUserAccountInfoService getUserAccountInfoService, PostUserAccountService postUserAccountService) {
		this.getUserAccountInfoService = getUserAccountInfoService;
		this.postUserAccountService = postUserAccountService;
	}
	
	//사용자 정보를 읽어온다. 로그인 서비스
	@ResponseBody
	@GetMapping("/v1/user-account-info")
	public GetUserAccountInfoOutDto getUserAccountInfo(@RequestBody @Valid GetUserAccountInfoInDto input) {
		GetUserAccountInfoOutDto userAccountInfo = getUserAccountInfoService.doLogin(input);
		
		return userAccountInfo;
	}
	
	//회원가입 서비스
	@ResponseBody
	@PostMapping("/v1/user-account")
	public PostUserAccountOutDto postUserAccount(@RequestBody @Valid PostUserAccountInDto input) {
		PostUserAccountOutDto userAccountInfo = postUserAccountService.postUserAccount(input);
		
		return userAccountInfo;
	}
}
