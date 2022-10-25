package com.lab.employee.controller;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexnet.lm.FlxException;
import com.lab.employee.entity.Department;
import com.lab.employee.license.LicenseInfo;
import com.lab.employee.license.LicenseTelemetryGenerator;
import com.lab.employee.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	public static final String DEPARTMENT_SIZE_FEATURE = "Departments";

	@Autowired
	DepartmentRepository repository;
	
	@Autowired
	LicenseInfo licenseInfo;
	
	@Autowired
	LicenseTelemetryGenerator telemetryGenerator;

	@GetMapping()
	public ResponseEntity<List<Department>> getAll() {
		List<Department> data = repository.findAll();
		return ResponseEntity.ok().body(data);
	}

	@GetMapping("/metrics")
	public ResponseEntity<Resource> getMetricsFile() throws IOException, FlxException {
		List<Department> data = repository.findAll();
		
		HashMap<String, String> customMetricsMap = getCustomMetricsMap(data);
		
		telemetryGenerator.generateCustomMetrics(customMetricsMap);

		String file = saveTempFile(data);
		return ResponseEntity.ok().contentType(APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", String.format("attachment; filename=\"%s\"", "metric.json"))
				.body(getFileAsResource(file));
	}

	private HashMap<String, String> getCustomMetricsMap(List<Department> data) {
		HashMap<String, String> map = new HashMap<>();
		map.put("dep_size", String.valueOf(data.size()));
		data.forEach(d -> {
			map.put("dep_" + d.getId() + "_name", d.getName());
			map.put("dep_" + d.getId() + "_size", String.valueOf(d.getNumberOfEmployees()));
		});
		
		return map;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Department> get(@PathVariable("id") Integer id) {
		Optional<Department> employee = repository.findById(id);
		if (employee.isPresent())
			return ResponseEntity.ok().body(employee.get());
		else
			return ResponseEntity.notFound().build();
	}

	@PostMapping()
	public Department save(@RequestBody Department employee) {
		return repository.save(employee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
		Boolean response = true;
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			response = false;
		}
		return ResponseEntity.accepted().body(response);
	}

	private String saveTempFile(List<Department> data) throws IOException {
		StringBuffer str = new StringBuffer();
		str.append(String.format("%s:%s", "dep_size", data.size()));
		str.append(System.lineSeparator());
		data.forEach(d -> {
			str.append(String.format("%s:%s", "dep_" + d.getId() + "_name", d.getName()));
			str.append(System.lineSeparator());
			str.append(String.format("%s:%s", "dep_" + d.getId() + "_size", d.getNumberOfEmployees()));
			str.append(System.lineSeparator());
		});

		Path createTempFile = Files.createTempFile("tmp_", "txt");
		Files.writeString(createTempFile, str.toString());
		return createTempFile.toAbsolutePath().toString();
	}

	private Resource getFileAsResource(String filePath) throws MalformedURLException {
		if (Files.exists(Paths.get(filePath)))
			return new UrlResource(Paths.get(filePath).toUri());

		return null;
	}
}