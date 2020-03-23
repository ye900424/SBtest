package ES;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * @author C.A.O
 * @date 2019/11/26
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EsMapping {

    private Long Id;

    private Long name;

    private Long code;
}
