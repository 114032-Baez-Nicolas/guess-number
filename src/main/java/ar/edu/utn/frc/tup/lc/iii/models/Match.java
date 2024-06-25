package ar.edu.utn.frc.tup.lc.iii.models;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class Match {

    private Long id;

    private Long userId;

    private MatchDifficulty difficulty;

    private Integer numberToGuess;

    private Integer remainingTries;

    private MatchStatus status;
}
