package apiserver.document.approval;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import apiserver.document.approval.dto.GetUserAccountInfoInDto;
import apiserver.document.approval.dto.GetUserAccountInfoOutDto;
import apiserver.document.approval.dto.PostUserAccountInDto;
import apiserver.document.approval.dto.PostUserAccountOutDto;
import apiserver.document.approval.service.GetUserAccountInfoService;
import apiserver.document.approval.service.PostUserAccountService;

/**
 * 사용자 정보 조회 테스트
 * @author jeongseoyeon
 * jointest123 ID 회원가입 및 정보를 조회
 */

@SpringBootTest
public class GetUserAccountInfoServiceTest {
	
	@Autowired
	PostUserAccountService postUserAccountService;
	
	@Autowired
	GetUserAccountInfoService getUserAccountInfoService;
	
	@Test
	public void postUserAccount() {
		PostUserAccountInDto input = new PostUserAccountInDto();
		input.setUserId("jointest123");
		input.setApproveAuthority(true);
		
		PostUserAccountOutDto output = postUserAccountService.postUserAccount(input);
		
		assertEquals("회원가입 성공", output.getResult());
		
	}
	
	@Test
	public void getApproverListTest() {
		GetUserAccountInfoInDto input = new GetUserAccountInfoInDto();
		input.setUserId("USER1");
		GetUserAccountInfoOutDto output = getUserAccountInfoService.doLogin(input);
		
		assertEquals(1, output.getUserNum());
		assertEquals("USER1", output.getUserId());
		
	}
}
