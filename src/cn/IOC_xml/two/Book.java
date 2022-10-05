package cn.IOC_xml.two;

/**
 * 使用set方法进行注入属性
 */
public class Book {
    //创建属性
    private String bName;
    private String bAuthor;
    private String bAddress;
    private String bId;

    //创建属性对应的set方法
    public void setbAddress(String bAddress) {
        this.bAddress = bAddress;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.setbName("abc");
    }

    public void test() {
        System.out.println(bName + ":" + bAuthor + ":" + bAddress + ":" + bId);
    }

}
