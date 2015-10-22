package models;

import java.util.HashSet;

public class Questionary {
	private int id;
	private Donation donation;
	private Status status;
	private HashSet<Question> questions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public HashSet<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(HashSet<Question> questions) {
		this.questions = questions;
	}
}
