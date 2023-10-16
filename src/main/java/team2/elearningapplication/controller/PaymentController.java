package team2.elearningapplication.controller;

public class PaymentController {
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
    payment controller 2
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
