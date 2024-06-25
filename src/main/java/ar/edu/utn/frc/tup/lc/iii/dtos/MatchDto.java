package ar.edu.utn.frc.tup.lc.iii.dtos;

import ar.edu.utn.frc.tup.lc.iii.models.MatchDifficulty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MatchDto {

    private Long id;

    private MatchDifficulty difficulty;

    private Integer remainingTries;

}
