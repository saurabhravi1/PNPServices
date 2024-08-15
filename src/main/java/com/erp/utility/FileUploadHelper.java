package com.erp.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.erp.dao.AddressMasterDAO;
import com.erp.entities.master.AddressMasterDTO;
import com.erp.service.AddressMasterService;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Component
public class FileUploadHelper {
	
	public static final String upload_dir = "C:\\Data\\Uploaded";
	
	
	@Autowired
	private AddressMasterService addressMasterService;
	
	public boolean uploadFile(MultipartFile file) {
		boolean result = false;

		try {

			InputStream is = file.getInputStream();
			byte[] data = is.readAllBytes();
			is.read(data);

			String finalPath = upload_dir + File.separator + file.getOriginalFilename();
			File targetFile = new File(finalPath);
			System.out.println("finalPath : " + finalPath);
			FileOutputStream fos = new FileOutputStream(targetFile);
			fos.write(data);

			FileReader fileReader = new FileReader(targetFile);
			CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build();
			CSVReader reader = new CSVReaderBuilder(fileReader)
					.withCSVParser(csvParser)
					//.withSkipLines(1)
					.build();

			
			String[] nextLine;
			
			List<String> header = Arrays.asList(reader.readNext());
			System.out.println("header size: "+header);
			List<AddressMasterDTO> masterList = new ArrayList<AddressMasterDTO>();

			int i = 0;
			while (((nextLine = reader.readNext()) != null) /*&& ++i<50*/ ) {
				try {
				Arrays.asList(nextLine).stream().forEach(System.out::print);
				//System.out.println(nextLine.length);
				//System.out.println();
				AddressMasterDTO master = new AddressMasterDTO();
				if ( !("".equals(nextLine[0]) || nextLine[0] == null)) {
					
					master.setArea(nextLine[header.indexOf("Area")]);
					master.setCity(nextLine[header.indexOf("City")]);
					master.setState(nextLine[header.indexOf("State")]);
					master.setZipcode(Integer.valueOf(nextLine[header.indexOf("Zipcode")]));
					master.setCountry(nextLine[header.indexOf("Country")]);
					masterList.add(master);
					
				}
				}catch(Exception e) {
					e.printStackTrace();
				}
				

			}
			addressMasterService.uploadAddressMaster(masterList);
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
}
