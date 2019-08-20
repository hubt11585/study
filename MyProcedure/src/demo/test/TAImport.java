package demo.test;

public class TAImport {
    String fund_code;
    String fund_id;

    public TAImport(String fund_id,String fund_code){
        this.fund_id = fund_id;
        this.fund_code = fund_code;
    }

    public String getFund_code() {
        return fund_code;
    }

    public void setFund_code(String fund_code) {
        this.fund_code = fund_code;
    }

    public String getFund_id() {
        return fund_id;
    }

    public void setFund_id(String fund_id) {
        this.fund_id = fund_id;
    }
}
