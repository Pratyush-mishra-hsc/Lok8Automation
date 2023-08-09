package keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ApplicationKeywords extends ValidationKeywords {

	public ApplicationKeywords() throws IOException {
		// TODO Auto-generated constructor stub
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\Generic.properties";

		System.out.println("starting with properties");
		System.out.println("Given final path");
		System.out.println(path);

		generic = new Properties();
		try {
			FileInputStream fs = new FileInputStream(path);
			System.out.println("FS linking done !!!!");
			
			generic.load(fs);

			String location = generic.getProperty("Platform") + ".properties";
			System.out.println("Required File name : " + location);

			String File = System.getProperty("user.dir") + "\\src\\test\\resources\\" + location;

			System.out.println("QA_File location : " + File);

			env = new Properties();

			try {
				FileInputStream fio = new FileInputStream(File);
				env.load(fio);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//softAssert = new softAssert();
	}

	public void Login() {

	}

	public void SelectDateFromCalender() {

	}

	public void verifyStockAdded() {

	}
	
	public void setReport(ExtentTest test) {
		// TODO Auto-generated method stub
		this.test=test;
	}

	/*
	 * public void EnterDatails(String string, String string2) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 */
}
