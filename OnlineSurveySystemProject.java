package OnlineSurvey;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SurveyQuestion {
    private String question;
    private ArrayList<String> options;

    public SurveyQuestion(String question, ArrayList<String> options) {
        this.question = question;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }
}

class SurveyResponse {
    private Map<String, String> responses;

    public SurveyResponse() {
        this.responses = new HashMap<>();
    }

    public void addResponse(String question, String answer) {
        responses.put(question, answer);
    }

    public Map<String, String> getResponses() {
        return responses;
    }
}

class OnlineSurveySystem {
    private ArrayList<SurveyQuestion> surveyQuestions;
    private ArrayList<SurveyResponse> surveyResponses;

    public OnlineSurveySystem() {
        this.surveyQuestions = new ArrayList<>();
        this.surveyResponses = new ArrayList<>();
    }

    public void addQuestion(String question, ArrayList<String> options) {
        SurveyQuestion surveyQuestion = new SurveyQuestion(question, options);
        surveyQuestions.add(surveyQuestion);
    }

    public void conductSurvey() {
        Scanner scanner = new Scanner(System.in);

        for (SurveyQuestion question : surveyQuestions) {
            System.out.println(question.getQuestion());
            ArrayList<String> options = question.getOptions();

            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Your answer (enter the option number): ");
            int answerIndex = scanner.nextInt();
            String selectedAnswer = options.get(answerIndex - 1);

            SurveyResponse response = new SurveyResponse();
            response.addResponse(question.getQuestion(), selectedAnswer);
            surveyResponses.add(response);
        }

        System.out.println("Survey completed. Thank you for participating!");

        // Optional: You can process or analyze the survey responses here.
    }

    public void displaySurveyResults() {
        for (SurveyResponse response : surveyResponses) {
            Map<String, String> responses = response.getResponses();

            for (Map.Entry<String, String> entry : responses.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("-----------");
        }
    }
}

public class OnlineSurveySystemProject {
    public static void main(String[] args) {
        OnlineSurveySystem surveySystem = new OnlineSurveySystem();

        // Add survey questions
        surveySystem.addQuestion("What is your favorite programming language?", 
                                new ArrayList<>(List.of("Java", "Python", "C++", "JavaScript")));

        surveySystem.addQuestion("How often do you code?", 
                                new ArrayList<>(List.of("Daily", "Weekly", "Monthly", "Rarely")));

        // Conduct the survey
        surveySystem.conductSurvey();

        // Display survey results
        surveySystem.displaySurveyResults();
    }
}