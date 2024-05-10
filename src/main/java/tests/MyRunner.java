package tests;


import org.junit.runner.JUnitCore;
import util.Config;
import util.ConfigReader;

public class MyRunner {

    public static void main(String[] args) throws Exception {
        Config config = ConfigReader.instance().getTestConfiguration();

        String dryRun = config.getTests().isDryrun() ? "true" : "false";
        System.setProperty("cucumber.execution.dry-run", dryRun.trim());

        String tags = config.getTests().getTags();
        if (tags != null && tags.trim().length() > 0) {
            System.setProperty("cucumber.filter.tags", tags);
        }
        String features = config.getTests().getFeatures();
        if (features != null && features.trim().length() > 0) {
            System.setProperty("cucumber.features", features);
        }

        System.setProperty("cucumber.publish.quiet", "true");


        JUnitCore junit = new JUnitCore();
        long start = System.currentTimeMillis();
        junit.run(MyTests.class);
        long end = System.currentTimeMillis();



    }


}
