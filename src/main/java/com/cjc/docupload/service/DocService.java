package com.cjc.docupload.service;

import java.util.List;

import com.cjc.docupload.model.Documents;

public interface DocService {

	Documents savedoc(Documents d);

	List<Documents> getDoc();

}
