package test;

/**
 * @author mehdi sarikhani
 * @date 23 June 2015 
 * 
 * A test suite to run all test cases.
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CarSimulationTest.class, TestCaseIncludeInDescriptionDoc.class })
public class AllTests {

}
