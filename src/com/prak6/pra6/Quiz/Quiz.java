import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz {
    // Deklarasi field untuk menyimpan daftar pertanyaan
    private List<Question> questions;

    public Quiz() {
        // Inisialisasi daftar pertanyaan
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        // Tambahkan pertanyaan ke daftar
        this.questions.add(question);
    }

    public void displayAllQuestions() {
        // Iterasi setiap pertanyaan dan tampilkan dengan format "Pertanyaan
        // x:<newline>" lalu detailnya dengan memanggil question.display() dan tambahkan
        // juga 1 newline setelah pemanggilan fungsi display
        for (int i = 0; i < questions.size(); i++) {
            System.out.printf("Pertanyaan %d:%n", i + 1);
            questions.get(i).display();
            System.out.println();
        }
    }

    public boolean checkAnswer(int questionIndex, int selectedOptionNumber) {
        // Validasi indeks pertanyaan, jika tidak valid maka keluarkan output:
        // "Question index out of bounds<newline>"
        // kemudian return false
        if (questionIndex < 0 || questionIndex >= questions.size()) {
            System.out.println("Question index out of bounds");
            return false;
        }

        // Ambil pertanyaan berdasarkan indeks
        Question question = questions.get(questionIndex);

        // Periksa apakah nomor opsi valid, jika tidak valid keluarkan output:
        // "Selected option is not available<newline>"
        // kemudian return false
        if (!question.isValidOption(selectedOptionNumber)) {
            System.out.println("Selected option is not available");
            return false;
        }

        // Kembalikan hasil pemeriksaan jawaban benar
        return question.isCorrect(selectedOptionNumber);
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(this.questions);
    }

    public int size() {
        // Mengembalikan jumlah pertanyaan dalam kuis
        return this.questions.size();
    }
}