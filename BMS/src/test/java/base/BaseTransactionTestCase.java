package base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * Junit测试基类 
 * 继承AbstractTransactionalJUnit4SpringContextTests 
 * 可实现事务回滚 
 * 
 */  

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath:applicationContext.xml")  
public abstract class BaseTransactionTestCase extends AbstractTransactionalJUnit4SpringContextTests{

}
