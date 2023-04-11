package com.victoriasmuk.daikichi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiController {
	@GetMapping("/daikichi")
	public String daikichi() {
		return "Welcome!";
	}
	@GetMapping("/daikichi/today")
	public String daikichiToday() {
		return "Today you will find luck in all your endeavors!";
	}
	@GetMapping("/daikichi/tomorrow")
	public String daikichiTomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	@GetMapping("/daikichi/travel/{location}")
	public String daikichiTravel(
			@PathVariable("location")String location)
	{
	return "Congratulations! You will soon travel to " + location;	
	}
	@GetMapping("daikichi/lotto/{lotto}")
	public String daikichiLotto(
			@PathVariable("lotto")Integer lotto)
	{
		if (lotto % 2 == 1) {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
		}
		return "You will take a grand journey in the near future, but be wary of temping offers";
	}
}
