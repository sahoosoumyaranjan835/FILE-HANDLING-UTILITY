package myjavaproject;
import java.io.*;
import java.util.*;

public class file01 {

    // Method to write content to a file
    public static void writeToFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to read content from a file
    public static void readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Reading file content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    // Method to modify file by replacing a word
    public static void modifyFile(String filename, String target, String replacement) {
        File file = new File(filename);
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line.replaceAll(target, replacement)).append(System.lineSeparator());
            }

        } catch (IOException e) {
            System.out.println("Error while reading the file.");
            e.printStackTrace();
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content.toString());
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error while writing to the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();

        System.out.print("Enter content to write to the file: ");
        String content = scanner.nextLine();
        writeToFile(filename, content);

        System.out.println("Reading the file:");
        readFromFile(filename);

        System.out.println("Enter word to replace: ");
        String target = scanner.nextLine();

        System.out.println("Enter replacement word: ");
        String replacement = scanner.nextLine();
        modifyFile(filename, target, replacement);

        System.out.println("Reading the modified file:");
        readFromFile(filename);

        scanner.close();
    }
}
