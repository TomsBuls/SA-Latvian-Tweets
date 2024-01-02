import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import lv.rtu.stemmerlv.StemmerLV;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TweetLemmatizer {

    public static void main(String[] args) throws IOException {
        // Input and output file paths
        String inputFile = "C:/Users/tomsb/Lemmas/Datasets/random_tweets.csv";
        String outputFile = "C:/Users/tomsb/Lemmas/Datasets/still_random_tweets.csv";

        // Create StemmerLV instance
        StemmerLV stemmer = new StemmerLV(true);
        boolean stopOnFirstMatch = false;
        boolean reportAnalysis = false;
        boolean allowGuessing = true;

        // Read and process the input CSV file
        try (FileReader fileReader = new FileReader(inputFile);
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader())) {

            // Get the headers from the input CSV
            List<String> headers = csvParser.getHeaderNames();
            
            // Prepare the CSV format for the output file with the same headers
            CSVFormat outputFormat = CSVFormat.DEFAULT.withHeader(headers.toArray(new String[0]));

            try (FileWriter fileWriter = new FileWriter(outputFile);
                 CSVPrinter csvPrinter = new CSVPrinter(fileWriter, outputFormat)) {

                for (CSVRecord record : csvParser) {
                    // Preserve all columns as they are
                    List<String> outputRecord = new ArrayList<>(record.size());

                    for (String header : headers) {
                        String columnValue = record.get(header);

                        // Only lemmatize the "text" column
                        if (header.equals("cleaned_text")) {
                            String[] words = columnValue.split("\\s+");
                            StringBuilder lemmatizedText = new StringBuilder();
                            for (String word : words) {
                                Set<String> lemmas = stemmer.lemmatize(word, stopOnFirstMatch, reportAnalysis);
                                if (!lemmas.isEmpty()) {
                                    lemmatizedText.append(lemmas.iterator().next()).append(" ");
                                } else {
                                    lemmatizedText.append(word).append(" ");
                                }
                            }
                            outputRecord.add(lemmatizedText.toString().trim());
                        } else {
                            outputRecord.add(columnValue);
                        }
                    }

                    csvPrinter.printRecord(outputRecord);
                }
            }
        }

        System.out.println("Lemmatization complete. Output written to " + outputFile);
    }
}
