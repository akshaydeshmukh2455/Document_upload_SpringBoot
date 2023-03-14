package com.cjc.docupload.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.docupload.model.Documents;
import com.cjc.docupload.repository.DocRepository;
import com.cjc.docupload.service.DocService;
@Service
public class DocServiceImpl implements DocService{

	@Autowired
	DocRepository drs;
	
	@Override
	public Documents savedoc(Documents d) {
		// TODO Auto-generated method stub
		return drs.save(d);
	}

	@Override
	public List<Documents> getDoc() {
		// TODO Auto-generated method stub
		return drs.findAll();
	}

}
