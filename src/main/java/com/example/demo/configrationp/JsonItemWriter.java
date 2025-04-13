package com.example.demo.configrationp;
import com.example.demo.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.List;

public class JsonItemWriter implements ItemWriter<Product> {

    private ObjectMapper objectMapper;
    private FileSystemResource outputResource;

    public JsonItemWriter(String outputFilePath) {
        this.objectMapper = new ObjectMapper();  // Jackson ObjectMapper for JSON conversion
        this.outputResource = new FileSystemResource("C:\\Users\\rprem\\git\\javaspringbootcontroller\\src\\main\\resources\\");
    }

    

	@Override
	public void write(Chunk<? extends Product> chunk) throws Exception {
		// TODO Auto-generated method stub
		try {
            // Serialize list of Product items to JSON and write it to the file
            objectMapper.writeValue(outputResource.getFile(), chunk);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write JSON", e);
        }	
	}

	
}
