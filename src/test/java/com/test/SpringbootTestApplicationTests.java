package com.test;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootTestApplicationTests {

	@Test
	void contextLoads() {
	}

	void testGitHub(){
        System.out.println("Everything is already!");
        System.out.println("第二次更新,主库删除，第4次更新了！");
    }
}
