package src.main.java.team2.elearningapplication.controller;
@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }
    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long quizId) {
        Quiz quiz = quizService.getQuizById(quizId);
        return ResponseEntity.ok(quiz);
    }
    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz createdQuiz = quizService.createQuiz(quiz);
        return ResponseEntity.ok(createdQuiz);
    }
    @PutMapping("/{quizId}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long quizId, @RequestBody Quiz quiz) {
        Quiz updatedQuiz = quizService.updateQuiz(quizId, quiz);
        return ResponseEntity.ok(updatedQuiz);
    }
    @GetMapping("/{quizId}/questions")
    public ResponseEntity<List<Question>> getQuestionsForQuiz(@PathVariable Long quizId) {
        List<Question> questions = questionService.getQuestionsByQuiz(quizId);
        return ResponseEntity.ok(questions);
    }
    @PostMapping("/{quizId}/questions")
    public ResponseEntity<Question> addQuestionToQuiz(@PathVariable Long quizId, @RequestBody Question question) {
        Question addedQuestion = questionService.addQuestionToQuiz(quizId, question);
        return ResponseEntity.ok(addedQuestion);
    }
    @GetMapping("/{quizId}/questions/{questionId}")
    public ResponseEntity<Question> getQuestionInQuiz(@PathVariable Long quizId, @PathVariable Long questionId) {
        Question question = questionService.getQuestionInQuiz(quizId, questionId);
        return ResponseEntity.ok(question);
    }
    @GetMapping("/{quizId}/questions/{questionId}")
    public ResponseEntity<Question> getQuestionInQuiz(@PathVariable Long quizId, @PathVariable Long questionId) {
        Question question = questionService.getQuestionInQuiz(quizId, questionId);
        return ResponseEntity.ok(question);
    }

}

