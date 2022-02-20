package edu.thomasdacosta.s3.file.ports;

import java.io.InputStream;

public interface FileService {
	
	public void saveFile(InputStream from, String to);

}
