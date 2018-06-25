package SpringTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by C.A.O on 2018/6/21.
 */
@Service
@Slf4j
public class OrOrderService {

    @Autowired
    OiQuoteService oiQuoteService;

    @Autowired
    OiOrderDao oiOrderDao;

    public void printStm(){

        System.out.println("hello order");

        oiQuoteService.printHello();

        oiOrderDao.wr();
    }
}
