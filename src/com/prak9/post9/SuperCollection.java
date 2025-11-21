import java.util.*;

public class SuperCollection {
    private List<Integer> collection;

    // TODO: Buat constructor yang menerima List<Integer> sebagai parameter
    // Inisialisasi atribut collection dengan parameter yang diterima
    public SuperCollection(List<Integer> collection) {
        this.collection = collection;
    }

    // TODO: Buat method partitionByCondition(int threshold)
    // Pisahkan collection menjadi dua grup: element <= threshold dan element > threshold
    // Return List<List<Integer>> dimana:
    // - Index 0 berisi element <= threshold
    // - Index 1 berisi element > threshold
    public List<List<Integer>> partitionByCondition(int threshold) {
        List<Integer> lessOrEqual = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (Integer element : this.collection) {
            if (element <= threshold) {
                lessOrEqual.add(element);
            }
            else {
                greater.add(element);
            }
        }

        List<List<Integer>> partitions = new ArrayList<>();
        partitions.add(lessOrEqual);
        partitions.add(greater);

        return partitions;
    }

    // TODO: Buat method findTopN(int n)
    // Return List<Integer> berisi n element terbesar dalam urutan descending
    // Jika n lebih besar dari ukuran collection, return semua element yang ada
    // Pastikan hasilnya terurut dari terbesar ke terkecil
    public List<Integer> findTopN(int n) {
        List<Integer> sortedList = new ArrayList<>(this.collection);

        sortedList.sort(Collections.reverseOrder());
        int size = sortedList.size();
        int limit = Math.min(n, size);

        return new ArrayList<>(sortedList.subList(0, limit));
    }

    // TODO: Buat method runningSum()
    // Return List<Integer> berisi cumulative sum
    // Element ke-i berisi jumlah dari element index 0 sampai i
    // Contoh: [1, 2, 3, 4] -> [1, 3, 6, 10]
    public List<Integer> runningSum() {
        List<Integer> cumulativeSum = new ArrayList<>();
        int sum = 0;

        for (Integer element : this.collection) {
            sum += element;
            cumulativeSum.add(sum);
        }

        return cumulativeSum;
    }

    // TODO: Buat method findPairsWithSum(int targetSum)
    // Cari semua pasangan element yang jika dijumlahkan = targetSum
    // Return List<String> dengan format "a+b=sum"
    // Hindari duplikat pasangan (a,b) dan (b,a) dianggap sama
    // Urutkan hasil berdasarkan nilai a
    public List<String> findPairsWithSum(int targetSum) {
        Set<String> pairs = new TreeSet<>();

        for (int i = 0; i < this.collection.size(); i++) {
            for (int j = i + 1; j < this.collection.size(); j++) {
                int a = this.collection.get(i);
                int b = this.collection.get(j);

                if(a+b == targetSum) {
                    int first = Math.min(a, b);
                    int second = Math.max(a, b);
                    pairs.add(first + "+" + second + "=" + targetSum);
                }
            }
        }
        return new ArrayList<>(pairs);
    }

    private static class FrequencyPair implements Comparable<FrequencyPair> {
        int value;
        int frequency;

        FrequencyPair(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(FrequencyPair other) {
            if (this.frequency != other.frequency) {
                return Integer.compare(other.frequency, this.frequency);
            }
            return Integer.compare(other.value, this.value);
        }
    }

    // TODO: Buat method getMostFrequentElements(int n)
    // Return List<Integer> berisi n element yang paling sering muncul
    // Jika ada element dengan frekuensi sama, pilih yang nilainya lebih besar
    public List<Integer> getMostFrequentElements(int n) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (Integer element : this.collection) {
            freqMap.put(element, freqMap.getOrDefault(element, 0) + 1);
        }

        List<FrequencyPair> freqList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freqList.add(new FrequencyPair(entry.getKey(), entry.getValue()));
        }

        Collections.sort(freqList);

        List<Integer> result = new ArrayList<>();
        int limit = Math.min(n, freqList.size());
        for (int i = 0; i < limit; i++) {
            result.add(freqList.get(i).value);
        }

        return result;
    }

    // TODO: Buat method getCollection()
    // Return collection yang sedang digunakan (type: List<Integer>)
    public List<Integer> getCollection() {
        return this.collection;
    }

    // TODO: Buat method setCollection(List<Integer> newCollection)
    // Set atribut collection dengan newCollection
    public void setCollection(List<Integer> newCollection) {
        this.collection = newCollection;
    }
}