package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which file do you want to copy?");
        String copyFrom = scanner.nextLine();

        System.out.println("Enter name of file");
        String newFile = scanner.nextLine();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(copyFrom));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                String newFileLine = String.format("%d|%s|%.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

                bufferedWriter.write(newFileLine);
            }

            bufferedWriter.close();
            bufferedReader.close();
            scanner.close();

        } catch (Exception ex) {
            System.out.println("An error has occurred");
        }
    }
}
