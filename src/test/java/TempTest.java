/**
 * @author C.A.O
 * @date 2020/1/6
 */
public class TempTest {

    public static Object lock = new byte[0];

    public static void main(String[] args) {
        TempTest tempTest = new TempTest();
        Response response = tempTest.transferAccounts(1L, 2L, 1000L, 3L);
        System.out.println(response);
    }

    public Response transferAccounts(Long sourceId, Long targetId, Long amount, Long orderId) {

        synchronized (lock) {
            Response resp = new Response();
            DBMock dbMock = new DBMock();
            dbMock.sourceRead();
            if (dbMock.sourceRead() - amount > 0) {
                dbMock.sourceUpdate();
                dbMock.targetUpdate();
            } else {
                return Response.fail("", "");
            }
            return resp;
        }


    }
}

class Response<T> {
    private String code;
    private String message;
    private Boolean success;
    private T result;

    public static Response fail(String code, String message) {
        Response resp = new Response();
        resp.code = code;
        resp.message = message;
        resp.success = false;
        return resp;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", success=" + success +
                ", result=" + result +
                '}';
    }
}

class DBMock {

    /**
     * 金额减少
     */
    void sourceUpdate() {
        // todo
    }

    Long sourceRead() {
        return null;
    }

    /**
     * 金额减少
     */
    void targetUpdate() {
        // todo
    }


}
