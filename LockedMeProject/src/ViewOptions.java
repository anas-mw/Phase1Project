import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ViewOptions {

	Scanner sc = new Scanner(System.in);
	String userInput;

	public void allOptions() throws IOException {
		System.out.println("Main Menu\n");
		
		System.out.println("Option A: List All Files\n");
		System.out.println("Option B: ");
		System.out.println("Add a file to existing directory list");
		System.out.println("Delete a user specified file from the existing directory list");
		System.out.println("Search for a specific file: ");
		System.out.println("Main Menu");
		System.out.println();
		System.out.println("Option C: Close Application");

		System.out.println();
		System.out.println("Select option: ");
		userInput = sc.next();

		while (true) {
			if (userInput.equalsIgnoreCase("A")) {
				optionA();
			} else if (userInput.equalsIgnoreCase("B")) {
				optionB();
			} else if (userInput.equalsIgnoreCase("C")) {
				optionC();
			} else {
				System.out.println("invalid input TRY AGAIN!\n");
				allOptions();
				return;
			}
			break;
		}

	}

	void optionA() throws IOException {
		File folder = new File("h://My Documents//LockedMeFolderExample"); // Create folder in the specified path
		File file = new File("h://My Documents//LockedMeFolderExample//example1.txt"); // Create file inside folder

		boolean isCreated = file.createNewFile();

		if (isCreated) { // Check if already exists
			System.out.println("File created in directory: " + folder.getName());

		} else {
			System.out.println("File Already exists");

		}

		String contents[] = folder.list(); // Lists all the files in the directory called folder

		System.out.println();
		System.out.println("List of all files in directory: " + folder.getName());
		

		for (int i = 0; i < contents.length; i++) {
			System.out.println(contents[i]);
		} 
		
		System.out.println();
		allOptions();
		


//		System.out.println();
//		if (!folder.exists()) { // Checking if it exists or not
//			folder.mkdirs(); // Does not exist then create folder directory
//			System.out.println("Folder directory created in: " + folder.getAbsolutePath());
//		} else {
//			System.out.println("Folder Already exists");
//		}

	}

	void optionB() throws IOException{
		System.out.println("B1. Add a file to existing directory");
		System.out.println("B2. Delete a specific file in current directory:");
		System.out.println("B3. Search for a file");
		System.out.println("B4. Main Menu");
		System.out.println("Select an option: ");
		userInput = sc.next();

		if (userInput.equalsIgnoreCase("B1")) {
			System.out.println("Adding a file to existing directory... ");
			File file = new File("h://My Documents//LockedMeFolderExample//example5.txt"); // Create file here

			boolean isCreated = file.createNewFile();

			if (isCreated) { // Check if already exists
				System.out.println("File: " + file.getName() + "" + " created in existing directory");
				allOptions();

			} else {
				System.out.println("File name already exists, change file name and try again \n");
				allOptions();
			}
		}
		if (userInput.equalsIgnoreCase("B2")) {
			System.out.println("Enter the file to be deleted: ");
			userInput = sc.next();	
		}
		
		if(userInput.equalsIgnoreCase("B3")){
			System.out.println("Searching for file...");
		}

		if (userInput.equalsIgnoreCase("B4")) {
			System.out.println("Going to Main Menu...\n");
			allOptions();
		}

	}

	void optionC() {
		System.out.println("Application closed!");

	}

}
