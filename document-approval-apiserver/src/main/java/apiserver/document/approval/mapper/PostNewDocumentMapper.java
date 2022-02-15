package apiserver.document.approval.mapper;


import org.apache.ibatis.annotations.Mapper;

import apiserver.document.approval.dto.PostNewApproveLineInDto;
import apiserver.document.approval.dto.PostNewDocumentInDto;

@Mapper
public interface PostNewDocumentMapper {
	
	int postNewDocument(PostNewDocumentInDto newDocument);
	
	int getDocumentCount();
	
	int postNewApproveLine(PostNewApproveLineInDto newApproveLine);
	
}
