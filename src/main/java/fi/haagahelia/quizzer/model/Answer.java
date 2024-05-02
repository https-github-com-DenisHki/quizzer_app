package fi.haagahelia.quizzer.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Answer {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long answerId;

    @Column(nullable = false)
    private String answerText;

    @Column(nullable = false)
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    public Answer(String answerText, boolean correct, Question question) {
        this.answerText = answerText;
        this.correct = correct;
        this.question = question;
    }

}
