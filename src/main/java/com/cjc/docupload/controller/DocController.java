package com.cjc.docupload.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.docupload.model.Documents;
import com.cjc.docupload.service.DocService;
import com.google.gson.Gson;

@RestController
public class DocController {
	@Autowired
	DocService dsr;
	
	@RequestMapping(value = "/docUpload" ,method =RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Documents docsave(@RequestPart(required = true , value="adharcard") MultipartFile f1,
			@RequestPart(required = true , value="pancard") MultipartFile f2,
			@RequestPart(required = true , value="photo") MultipartFile f3,
			@RequestPart(required = true , value="signature") MultipartFile f4,
			@RequestPart("doc") String doc) throws IOException
	{
		Documents d= new Documents();
		
		d.setAdharcard(f1.getBytes());
		d.setPancard(f2.getBytes());
		d.setPhoto(f3.getBytes());
		d.setSignature(f4.getBytes());
		
		Gson g=new Gson();
		
		Documents ds=g.fromJson(doc, Documents.class);
		
		d.setCustId(ds.getCustId());
		d.setCustName(ds.getCustName());
		
		
		Documents dls=dsr.savedoc(d);
		
		return dls;
	}
	
	@GetMapping("/getDocs")
	public List<Documents> getDocuments()
	{
		return dsr.getDoc();
	}
}
