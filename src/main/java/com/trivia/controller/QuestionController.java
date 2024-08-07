package com.trivia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trivia.model.QuestionDto;
import com.trivia.service.QuestionServiceImpl;
import com.trivia.utils.Log;

@RestController
@RequestMapping(path = "/question")
@CrossOrigin("*")
public class QuestionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(QuestionController.class);

	@Autowired
	private QuestionServiceImpl questionServiceImpl;

	/**************
	 * Get methods
	 **************/
	@GetMapping("/getAllQuestions")
	public ResponseEntity<?> getQuestions() {
		Log.infoGreen(LOGGER, "get all question");
		return ResponseEntity.status(HttpStatus.OK).body(questionServiceImpl.getAllQuestions());
	}

	@GetMapping("/getQuestionById/{id}")
	public ResponseEntity<?> getQuestionById(@PathVariable(name = "id") long id) {
		Log.infoGreen(LOGGER, "get Question By Id : " + id);
		return ResponseEntity.status(HttpStatus.OK).body(questionServiceImpl.getQuestionById(id));
	}

	/******************
	 * Create methods
	 ******************/
	@PostMapping("/addQuestion")
	public ResponseEntity<?> addQuestion(@RequestBody QuestionDto questionDto) {
		Log.infoGreen(LOGGER, "add Question");
		return ResponseEntity.status(HttpStatus.CREATED).body(questionServiceImpl.addQuestion(questionDto));
	}

	/******************
	 * Update methods
	 ******************/
	@PutMapping("/updateQuestion")
	public ResponseEntity<?> updateQuestion(@RequestBody QuestionDto questionDto) {
		Log.infoGreen(LOGGER, "update Question");
		return ResponseEntity.status(HttpStatus.CREATED).body(questionServiceImpl.updateQuestion(questionDto));
	}

	/******************
	 * Delete methods
	 ******************/
	@DeleteMapping("/deleteQuestion/{id}")
	public String deleteQuestion(@PathVariable(name = "id") long id) {
		Log.infoGreen(LOGGER, "delete Question by Id : " + id);
		questionServiceImpl.deleteQuestionById(id);
		return "cde";
	}
}
