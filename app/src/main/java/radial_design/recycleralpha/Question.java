package radial_design.recycleralpha;

class Question {
    String[] answers = new String [4];
    String answer;
    String cat;
    int photoId;
    int questionNum;

    Question(int questionNum, String cat, String [] answers, String answer, int photoId) {
        this.questionNum = questionNum;
        this.cat = cat;
        this.answers = answers;
        this.answer=answer;
        this.photoId = photoId;
    }
}

