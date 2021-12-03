package com.example.csvReader.component;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.csvReader.entity.EmployeeDetails;
import com.example.csvReader.repository.EmployeeRepository;
import com.opencsv.bean.CsvToBeanBuilder;

@Component
public class LoadCsvDataOnStartUp implements ApplicationRunner {
	EmployeeRepository userRepository;

	@Autowired
	public LoadCsvDataOnStartUp(EmployeeRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Value("${employeeFile.path}")
	private String employeeFile;

	@Override
	public void run(ApplicationArguments args) throws IOException, URISyntaxException {
		Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(employeeFile).toURI()));
		List<EmployeeDetails> beans = new CsvToBeanBuilder<EmployeeDetails>(reader).withType(EmployeeDetails.class)
				.build().parse();
		for (EmployeeDetails userDetails : beans) {
			userRepository.save(userDetails);
		}
	}

}
