package edu.hrbust.common.dto.request;


import lombok.Setter;
import org.junit.Test;

public class BaseRequestDTOTest extends BaseRequestDTO {
    @Setter
    private String name;
    @Setter
    private String age;

    @Test
    public void test() {
        BaseRequestDTOTest baseRequestDTOTest = new BaseRequestDTOTest();
        baseRequestDTOTest.setAge("123");
        baseRequestDTOTest.setName("avc");
        System.out.println(baseRequestDTOTest.toString());
    }
}
