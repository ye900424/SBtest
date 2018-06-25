package SpringTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by C.A.O on 2018/6/21.
 */
@Service
@Slf4j
public class OiQuoteService {
    public void printHello(){
        System.out.println("hello quote!");
    }
}
