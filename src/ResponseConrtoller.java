public class ResponseConrtoller {
    private static final String[][] responses = {
            {"/demo" , "GET" , "[test]"},
            {"/demo02" , "GET" , "[test02]"}
    };

    public static String[][] getResponses() {
        return responses;
    }
}
