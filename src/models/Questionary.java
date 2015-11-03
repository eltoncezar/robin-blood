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
		return "Questionary [id=" + id + ", screening=" + screening + ", questions=" + questions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questionary other = (Questionary) obj;
		if (this.id != other.id)
			return false;
		return true;
	}
}
