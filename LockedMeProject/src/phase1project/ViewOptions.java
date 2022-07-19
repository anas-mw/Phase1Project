package phase1project;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ViewOptions extends Main {

	Scanner sc = new Scanner(System.in);
	String userinput;

	public void allOptions() throws IOException {

		System.out.println("Main Menu \n");
		System.out.println("Option A: List all Files \n");
		System.out.println("Option B: ");
		System.out.println("Add File");
		System.out.println("Delete File");
		System.out.println("Search File");
		System.out.println("Main Menu \n");
		System.out.println("Option C: Close Application \n");

		System.out.println("Select an option: ");
		userinput = sc.next();

		if (userinput.equalsIgnoreCase("A")) {
			optionA();
		}
		if (userinput.equalsIgnoreCase("B")) {
			optionB();
		}
		if (userinput.equalsIgnoreCase("C")) {
			optionC();
		} else {
			System.out.println("Error, TRY AGAIN! \n ");
			allOptions();
		}
	}

	void optionA() throws IOException {
		System.out.println("NOTE: ALL FOLDERS WILL BE CREATED IN SAME DIRECTORY AS PROJECT \n");
		System.out.println("If a folder does not exist, you will be prompted to create one.");
		System.out.println("Enter existing folder or new folder to be created: (check project directory if you are not sure) \n ");
		String folderName = sc.next();
		File folder = new File(folderName);

		if (!folder.exists()) {
			folder.mkdir();
			System.out.println("Folder: " + folder.getName() + " created successfully!");
			allOptions();
		} else {

			String contents[] = folder.list();

			System.out.println();
			System.out.println("List of all files in directory: " + folder.getName());

			for (int i = 0; i < contents.length; i++) {
				System.out.println(contents[i]);
			}
			System.out.println();

			System.out.println("View all the options available for you below: \n ");
			optionB();
		}
	}

	void optionB() throws IOException {
		System.out.println("B1. Add a file to existing folder ");
		System.out.println("B2. Delete a File");
		System.out.println("B3. Search for a File");
		System.out.println("B4. Main Menu");

		userinput = sc.next();

		if (userinput.equalsIgnoreCase("B1")) {
			System.out.println("Enter file name: ");
			String fileName = sc.next();

			System.out.println("Enter folder path: (example: c://users://documents...");
			String userFilePath = sc.next();

			File userFile = new File(userFilePath, fileName);

			System.out.println("Correct path? y or n ");
			String userChoice = sc.next();

			if (userChoice.equalsIgnoreCase("Y")) {
				userFile.createNewFile();
				System.out.println("File: " + userFile.getName() + " created successfully");

				System.out.println();
				allOptions();
			} else {
				System.out.println("Failed to create file");
				allOptions();
			}
		}

		if (userinput.equalsIgnoreCase("B2")) {
			System.out.println("Enter file to be deleted: ");
			String fileName = sc.next();

			System.out.println("Enter file path: ");
			String userFilePath = sc.next();

			File userFile = new File(userFilePath, fileName);

			if (!userFile.exists()) {
				System.out.println("File does not exist in this path, check name and try again! \n");
				allOptions();
			}

			System.out.println("Correct Path? Y or N ");
			String userChoice = sc.next();

			if (userChoice.equalsIgnoreCase("Y")) {
				userFile.delete();
				System.out.println("File: |" + userFile.getName() + "| deleted successfully!\n");
				allOptions();
			} else {
				System.out.println("Failed to delete file, Try again! \n ");
				allOptions();
			}

		}

		if (userinput.equalsIgnoreCase("B3")) {
			System.out.println("Enter file to be searched: ");
			String fileName = sc.next();

			System.out.println("Enter file path: ");
			String userFilePath = sc.next();

			File userFile = new File(userFilePath, fileName);

			if (!userFile.exists()) {
				System.out.println("File does not exist in this path, check path and name and try again \n");
				allOptions();
			}

			System.out.println("Correct path? Y or N ");
			String userChoice = sc.next();

			if (userChoice.equalsIgnoreCase("Y")) {
				System.out.println("Results: " + userFile.getName());
				allOptions();
			} else {
				System.out.println("File does not exist in this path, Search again! ");
				allOptions();
			}
		}

		if (userinput.equalsIgnoreCase("B4")) {
			allOptions();
		}

	}

	void optionC() {
		System.out.println("Application Closed!");
	}

}
