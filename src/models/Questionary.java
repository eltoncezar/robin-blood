package models;

import java.util.List;

public class Questionary {
	private int id;
	private Screening screening;
	private List<QuestionaryQuestion> questions;

	public Questionary() {
		super();
	}

	public Questionary(int id, Screening screening,
			List<QuestionaryQuestion> questions) {
		super();
		this.id = id;
		this.screening = screening;
		this.questions = questions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Screening getScreening() {
		return screening;
	}

	public void setScreening(Screening donation) {
		this.screening = donation;
	}

	public List<QuestionaryQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionaryQuestion> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "[" + this.id + "] " + this.screening.getDonation().getDonor().getName();
	}
}
