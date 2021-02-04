package com.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.ImageDTO;
import com.app.dao.ResponseDTO;
import com.app.pojos.User;
import com.app.dao.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
@RequestMapping("/image")
public class ImageController {
	@Value("${file.upload.location}")
	private String location;
	@Autowired
	private UserRepository userRepo;
	
	public ImageController() {
		System.out.println("inside ImageController constructor ");
	}
	//add a method to upload User details in JSON format n multipart image file , to save in DB
	//Tested with angular front end n postman
	@PostMapping("/upload")
	public ResponseDTO fileUploadWithParams(@RequestParam String dtls, @RequestParam MultipartFile imageFile) {
		System.out.println("data " + dtls + " " + imageFile.getOriginalFilename());
		try {
			//un marshalling json--> java
			User u = new ObjectMapper().readValue(dtls, User.class);
			u.setImage(imageFile.getBytes());
			u.setImageContentType(imageFile.getContentType());

			// imageFile.transferTo(new File(location, imageFile.getOriginalFilename()));
			// System.out.println("user dtls " + u);
			userRepo.save(u);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseDTO("File uploaded :" + imageFile.getOriginalFilename() + " @ ", LocalDateTime.now());
	}

//Add Method to download image from DB in angular front end , with specified user id
	@GetMapping("/download/{userId}")
	public ResponseEntity<?> downloadImage(@PathVariable int userId) throws IOException {
		System.out.println("in img download " + userId);
		User u = userRepo.findById(userId).get();
//		Path path = Paths.get(location, imgName);
		ImageDTO img = new ImageDTO();
		// img.setName(imgName);
		img.setData(u.getImage());
		img.setType(u.getImageContentType());
//		System.out.println(img.getType());

		return new ResponseEntity<>(img, HttpStatus.OK);

	}
	/*Sample JSON data : dtls : {"email" : "rama@gmail.com",	"age" : 27	}*/
	//add a method to upload User details in JSON format n multipart image file , to save in server side folder
	@PostMapping("/upload_folder")
	public ResponseDTO fileUploadInFolder(@RequestParam String dtls, @RequestParam MultipartFile imageFile) {
		System.out.println("data " + dtls + " " + imageFile.getOriginalFilename() + " " + location);
		try {
			User u = new ObjectMapper().readValue(dtls, User.class);
			imageFile.transferTo(new File(location, imageFile.getOriginalFilename()));
			System.out.println("user dtls " + u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseDTO("File uploaded :" + imageFile.getOriginalFilename(), LocalDateTime.now());
	}
	//Add a method to download image from server side folder to angular front end
	@GetMapping("/download3/{imgName}")
	public ResponseEntity<?> downloadImage(@PathVariable String imgName) throws IOException {
		System.out.println("in img download " + imgName);
		Path path = Paths.get(location, imgName);
		ImageDTO img = new ImageDTO();
		img.setName(imgName);
		img.setData(Files.readAllBytes(path));
		img.setType(Files.probeContentType(path));
		System.out.println(img.getType());
		return new ResponseEntity<>(img, HttpStatus.OK);

	}

	// Tested ok with browser n postman : to download image from server side folder to postman or browser.
	@GetMapping("/download2/{imgName}")
	//Sample URL : http://localhost:8080/image/download2/plums.jfif
	public ResponseEntity<InputStreamResource> getImage(@PathVariable String imgName) throws IOException {

		System.out.println("in img download 2 " + (location + imgName));
		Path path = Paths.get(location, imgName);
		InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(path.toFile()));

		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", Files.probeContentType(path));
		return ResponseEntity.ok().headers(headers).body(inputStreamResource);
	}

}
