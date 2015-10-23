package models;

public class QuestionaryQuestion {
	private int id;
	private Question question;
	private boolean answer;

	public QuestionaryQuestion() {
		super();
	}

	public QuestionaryQuestion(int id, Question question, boolean answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public boolean getAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "[" + this.id + "] " + this.question.getDescription() + ": "
				+ this.answer;
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
		QuestionaryQuestion other = (QuestionaryQuestion) obj;
		if (this.id != other.id)
			return false;
		return true;
	}
}
