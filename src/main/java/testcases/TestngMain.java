package testcases;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class TestngMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	//	TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
	//	suites.add("E:/Ramesh pendrive/Aish/POM/regression.xml");
		suites.add("E:/Ramesh pendrive/Aish/POM/collections.xml");//path to xml..
	//	suites.add("c:/tests/testng2.xml");
		testng.setTestSuites(suites);
		testng.run();
	}

}
