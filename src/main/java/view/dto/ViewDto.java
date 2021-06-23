package view.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ViewDto {
    private String carNamesInput;
    private String raceCountInput;

//    public ViewDto(String carNamesInput, String raceCountInput) {
//        this.carNamesInput = carNamesInput;
//        this.raceCountInput = raceCountInput;
//    }
//
//    public String getCarNamesInput() {
//        return carNamesInput;
//    }
//
//    public String getRaceCountInput() {
//        return raceCountInput;
//    }
}
