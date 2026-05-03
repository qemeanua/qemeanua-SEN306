public class OrderResult {
    private final boolean worked;
    private final String trackingNum;
    private final String msg;

    public OrderResult(boolean worked, String trackingNum, String msg) {
        this.worked = worked;
        this.trackingNum = trackingNum;
        this.msg = msg;
    }

    public boolean didItWork() { return worked; }
    public String getTrackingNum() { return trackingNum; }
    public String getMessage() { return msg; }
}