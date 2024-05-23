package Lab5.Utility;

public class ExecutionResponse {
    public boolean executeResponse;
    public String massage;

    public ExecutionResponse(String massage) {
        this.massage = massage;
    }

    public ExecutionResponse(boolean executeResponse, String massage) {
        this.executeResponse = executeResponse;
        this.massage = massage;
    }

    public boolean getExitCode() { return executeResponse; }
    public String getMassage() { return massage; }
    public String toString() { return String.valueOf(executeResponse)+"; "+massage; }


}
