package com.trivia.entity;

import java.util.Calendar;
import java.util.Random;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdentifierGenerator implements IdentifierGenerator, Configurable {

	private static final long serialVersionUID = 1411134855443728529L;
	private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		Calendar calendar = Calendar.getInstance();
		return "Any_Prefix_I_want_to_add" + generatedRandomId() + generateRandomStringId() + calendar.get(Calendar.YEAR);
	}

	public int generatedRandomId() {
		Random random = new Random();
		return random.nextInt(100);
	}

	public String generateRandomStringId() {
		Random random = new Random();
		StringBuilder generatedId = new StringBuilder();
		// Here, I will generate a random String of length of 10 characters
		for (int i = 0; i < 10; i++) {
			generatedId.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
		}
		return new String(generatedId);
	}
}
