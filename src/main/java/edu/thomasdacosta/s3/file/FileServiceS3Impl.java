package edu.thomasdacosta.s3.file;

import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Component;

import edu.thomasdacosta.s3.file.ports.FileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Profile( { "localstack" })
public class FileServiceS3Impl implements FileService {
	
	@Value("${bucket}")
	private String bucket;
	
    @Autowired
    private ResourceLoader resourceLoader;	

	@Override
	public void saveFile(InputStream from, String to) {
		Resource resource = this.resourceLoader.getResource(String.format("s3://%s/%s", bucket, to));
		WritableResource writableResource = (WritableResource) resource;
		
        try (OutputStream outputStream = writableResource.getOutputStream()) {
        	from.transferTo(outputStream);
        } catch (Exception ex) {
        	log.error(ex.getMessage(), ex);
        }		
	}

}
