package game.view.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class UserInputDto {
    private final String carNames;
    private final String roundCount;
}
