package validateTest.simpleTest;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by C.A.O on 2018/8/29.
 */
@Data
@NoArgsConstructor
public class City {

    @NotNull(message = "@NotNull测试")
    private String id;

//    @AssertTrue
//    private Boolean name;
}
