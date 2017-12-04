package msu.classes;

public class CBean {
    public CBean() {
        Value1 = null;
        Value2 = null;
        Value3 = null;
    }

    public CBean(String v1, String v2, String v3) {
        Value1 = v1;
        Value2 = v2;
        Value3 = v3;
    }

    private String Value1;
    private String Value2;
    private String Value3;

    public void setValue1(String value1) {
        Value1 = value1;
    }

    public void setValue2(String value2) {
        Value2 = value2;
    }

    public void setValue3(String value3) {
        Value3 = value3;
    }

    public String getValue1() {
        return Value1;
    }

    public String getValue2() {
        return Value2;
    }

    public String getValue3() {
        return Value3;
    }
}
