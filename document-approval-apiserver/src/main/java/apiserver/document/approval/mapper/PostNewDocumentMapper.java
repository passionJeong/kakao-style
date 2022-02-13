package apiserver.document.approval.mapper;


import org.apache.ibatis.annotations.Mapper;

import apiserver.document.approval.dto.PostNewDocumentInDto;

@Mapper
public interface PostNewDocumentMapper {
	
	int postNewDocument(PostNewDocumentInDto newDocument);
	
}
