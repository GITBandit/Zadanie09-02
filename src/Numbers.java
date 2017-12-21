import java.io.*;
import java.util.Scanner;

public class Numbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ile liczb chcesz wprowadzić ?");
        int noOfNumbers = scanner.nextInt();


        // table creation

        double[] numbers = new double[noOfNumbers];

        for (int i = 0; i<numbers.length; i++){
            System.out.println("Podaj liczbę");
            numbers[i] = scanner.nextDouble();
        }
        scanner.nextLine();

        for (double x: numbers){
            System.out.println(x);
        }

        String fileName = "plikPierwszy.txt";
        File file = new File(fileName);

        // file creation

        boolean fileExists = file.exists();

        if (!fileExists){
            try {
                file.createNewFile();
            } catch (IOException er){
                System.out.println("Nie utworzono pliku.");
            }
        }

        // inserting data into the file

        try(
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter writer = new BufferedWriter(fileWriter);
        ) {
            for (double z : numbers){
                writer.write(String.valueOf(z));
                writer.newLine();
            }
        } catch (IOException err){
            System.out.println("Nie udało się zapisać");
            err.printStackTrace();
        }

        // testing and printing

        System.out.println(" -- Test -- ");

        try(
                FileReader fileReader = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException err2) {
                System.out.println("Nie udało się odczytać");
                err2.printStackTrace();

        }
    }

}
