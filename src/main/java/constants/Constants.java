package constants;

public class Constants {

    public static class RunVariable {
        public static String server = Servers.JP_URL;
        public static String path = "";
    }

    public static class Servers {
        public static String SWAPI_URL = "https://swapi.dev/";
        public static String JP_URL = "https://jsonplaceholder.typicode.com";
        public static String REQUESTBIN_URL = "https://abd4ee8597c7f8fde2645208980177ee.m.pipedream.net";
        public static String GOOGLE_PLACES_URL;
    }

    public static class Path {
        public static String SWAPI_PATH = "/api/";
        public static String GOOGLE_PLACES_PATH;
    }

    public static class Actions {
        //swapi
        public static String SWAPI_GET_PEOPLE = "people/";

        //jsonplaceholder
        public static String JP_GET = "posts/";
        public static String JP_PUT = "posts/1";
        public static String JP_DELETE = "posts/1";
        public static String JP_POST = "posts/";

        //google
        public static String GOOGLE_PLACES_URL;
    }
}
