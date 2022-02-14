package apiserver.document.approval;

import static org.junit.jupiter.api.Assertions.assertEquals;

import apiserver.document.approval.dto.*;
import apiserver.document.approval.service.GetApproverListService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import apiserver.document.approval.service.GetUserAccountInfoService;
import apiserver.document.approval.service.PostUserAccountService;

import java.util.List;

/**
 * 사용자 정보 조회 테스트
 * @author jeongseoyeon
 * jointest1, jointest2 ID 회원가입 -> 로그인 -> 결재자 정보 가져오기
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GetUserAccountInfoServiceTest {
	
	@Autowired
	PostUserAccountService postUserAccountService;
	
	@Autowired
	GetUserAccountInfoService getUserAccountInfoService;

	@Autowired
	GetApproverListService getApproverListService;
	
	@Test
	@Order(1)
	public void postUserAccount() {
		PostUserAccountInDto input = new PostUserAccountInDto();
		input.setUserId("jointest1");
		input.setUserPw("password1");
		input.setApproveAuthority(true);
		
		PostUserAccountOutDto output = postUserAccountService.postUserAccount(input);

		assertEquals("회원가입 성공", output.getResult());

		input.setUserId("jointest2");
		input.setUserPw("password2");
		input.setApproveAuthority(false);

		output = postUserAccountService.postUserAccount(input);

		assertEquals("회원가입 성공", output.getResult());

	}

	@Test
	@Order(2)
	public void getUserAccountInfoServiceTest() {
		GetUserAccountInfoInDto input = new GetUserAccountInfoInDto();
		input.setUserId("jointest1");
		input.setUserPw("password1");
		GetUserAccountInfoOutDto output = getUserAccountInfoService.doLogin(input);

		assertEquals(4, output.getUserNum());
		assertEquals("jointest1", output.getUserId());

	}

	@Test
	@Order(3)
	public void getApproverListTest() {
		GetApproverListInDto input = new GetApproverListInDto();
		List<GetApproverListOutDto> output = getApproverListService.getApproverList();

		assertEquals(3, output.size());
		assertEquals("jointest1", output.get(2).getUserId());

	}
}
