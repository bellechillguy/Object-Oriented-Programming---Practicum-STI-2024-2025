import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    // Deklarasi field untuk menyimpan teks pertanyaan
    private String text;
    // Deklarasi field untuk daftar Option
    private List<Option> options;
    // Deklarasi field untuk indeks jawaban yang benar
    private int correctAnswerIndex;

    public Question(String text) {
        // Inisialisasi teks pertanyaan dan struktur data daftar option
        this.text = text;
        this.options = new ArrayList<>();
        // Atur nilai awal indeks jawaban benar (misalnya -1)
        this.correctAnswerIndex = -1;
    }

    public void addOption(String optionText, boolean correct) {
        // Buat objek Option baru menggunakan inner class
        Option newOption = new Option(optionText);
        // Tambahkan option ke dalam daftar
        this.options.add(newOption);
        // Jika parameter correct true, perbarui indeks jawaban benar
        if (correct) {
            this.correctAnswerIndex = this.options.size() - 1;
        }
    }

    public void display() {
        // Cetak teks pertanyaan yang diakhiri newline
        System.out.println(this.text);
        // Iterasi seluruh option dan tampilkan dengan format "nomor. teks<newline>"
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, options.get(i).getText());
        }
    }

    public boolean isCorrect(int selectedOptionNumber) {
        // Konversi nomor 1-based menjadi indeks 0-based dan bandingkan dengan
        // jawaban benar yang disimpan di dalam kelas
        return (selectedOptionNumber - 1) == this.correctAnswerIndex;
    }

    public boolean isValidOption(int selectedOptionNumber) {
        // Periksa apakah nomor opsi berada dalam rentang indeks daftar option
        return selectedOptionNumber > 0 && selectedOptionNumber <= this.options.size();
    }

    public List<Option> getOptions() {
        return Collections.unmodifiableList(this.options);
    }

    public class Option {
        // Deklarasi field untuk menyimpan teks option
        private String optionText;

        private Option(String text) {
            // Simpan teks option pada field yang sesuai
            this.optionText = text;
        }

        public String getText() {
            // Mengembalikan teks option
            return this.optionText;
        }
    }
}