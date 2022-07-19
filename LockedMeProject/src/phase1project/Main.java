// Main File
package phase1project;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		WelcomeMessage wm = new WelcomeMessage();
		wm.display();
		
		ViewOptions vo = new ViewOptions();
		vo.allOptions();

	}

}
