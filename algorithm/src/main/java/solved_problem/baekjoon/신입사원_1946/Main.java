package solved_problem.baekjoon.신입사원_1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = toInt(br.readLine());

        for (int i = 0; i < testCase ; i++) {
            int applicant = toInt(br.readLine())ª;

            List<Applicant> applicants = new ArrayList<>();
            for (int j = 0; j < applicant; j++) {
                st = new StringTokenizer(br.readLine());
                String documentScore = st.nextToken();
                String interviewScore = st.nextToken();
                applicants.add(new Applicant(toInt(interviewScore), toInt(documentScore)));
            }
            solution(applicants);
            count = 0;
        }

        br.close();
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    private static void solution(List<Applicant> applicants) {
        applicants.sort(Comparator.comparingInt(Applicant::getDocumentScore));

        print(applicants);

        int pivot = applicants.get(0).getInterviewScore();
        for (Applicant applicant : applicants) {
            int interviewScore = applicant.getInterviewScore();
            if (interviewScore <= pivot) {
                pivot = applicant.getInterviewScore();
                count++;
            }
        }

        System.out.println(count);
    }

    private static void print(List<Applicant> applicants) {
        for (Applicant applicant : applicants) {
            System.out.println(applicant);
        }
    }
}

class Applicant {
    private final int interviewScore;
    private final int documentScore;

    public Applicant(int interviewScore, int documentScore) {
        this.interviewScore = interviewScore;
        this.documentScore = documentScore;
    }

    public int getInterviewScore() {
        return interviewScore;
    }

    public int getDocumentScore() {
        return documentScore;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "interviewScore=" + interviewScore +
                ", documentScore=" + documentScore +
                '}';
    }
}
/*
4
        3 2
        1 4
        4 1
        2 3
        5 5

3
        3 6
        7 3 //
        4 2
        1 4 //
        5 7 //
        2 5 //
        6 1

        - 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램
*/
