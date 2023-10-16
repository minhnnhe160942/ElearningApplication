package team2.elearningapplication.controller;

public class blogController {
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
}
