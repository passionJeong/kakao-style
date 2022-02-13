package apiserver.document.approval.service;

import apiserver.document.approval.dto.PostNewDocumentInDto;
import apiserver.document.approval.dto.PostNewDocumentOutDto;

public interface PostNewDocumentService {
	public PostNewDocumentOutDto postNewDocument(PostNewDocumentInDto newDocument);
}
