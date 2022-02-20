package edu.thomasdacosta.s3.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.thomasdacosta.s3.file.ports.FileService;

@RestController
@RequestMapping("/")
public class AwsS3Controller {
	
	@Autowired
	private FileService fileService;
	
	@Value("classpath:file.txt")
	private Resource file;	
	
	@GetMapping(path = "s3")
	public String saveFile() throws IOException {
		fileService.saveFile(file.getInputStream(), "file.txt");
		return "Arquivo salvo com sucesso.";
	}
	
}
