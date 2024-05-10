package util;

public class Config {


    Application application;
    Tests tests;


    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Tests getTests() {
        return tests;
    }

    public void setTests(Tests tests) {
        this.tests = tests;
    }

    public class Application {
        String name;
        String url;
        String user;
        String password;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public enum ScreenshotMode {
        all, failure
    }


    public class Tests {
        String browser = "chrome";
        boolean dryrun = false;
        String features;
        ScreenshotMode screenshots = ScreenshotMode.failure;
        String tags;

        public String getBrowser() {
            return browser;
        }

        public void setBrowser(String browser) {
            this.browser = browser;
        }

        public boolean isDryrun() {
            return dryrun;
        }

        public void setDryrun(boolean dryrun) {
            this.dryrun = dryrun;
        }

        public String getFeatures() {
            return features;
        }

        public void setFeatures(String features) {
            this.features = features;
        }

        public ScreenshotMode getScreenshots() {
            return screenshots;
        }

        public void setScreenshots(ScreenshotMode screenshots) {
            this.screenshots = screenshots;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }
    }




}
