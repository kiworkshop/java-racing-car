package view.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class ViewDto {
    private final List<String> carNames;
    private final int raceCount;
}
