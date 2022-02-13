package apiserver.document.approval.mapper;

import org.apache.ibatis.annotations.Mapper;

import apiserver.document.approval.dto.GetDocumentInfoInDto;
import apiserver.document.approval.dto.GetDocumentInfoOutDto;

@Mapper
public interface GetDocumentInfoMapper {
	
	GetDocumentInfoOutDto getDocumentInfo(GetDocumentInfoInDto input);

}
