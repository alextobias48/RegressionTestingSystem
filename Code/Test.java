import java.util.ArrayList;




public class Test {
public static void main(String args[]){
		ArrayList<TestCase> testCases = TestCase.getTestCases();
		
		for(TestCase t: testCases){
			System.out.println(t.getTestCaseName() + "   " + t.getScriptType());
		}
		
	}
}
