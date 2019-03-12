package edu.hrbust.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleResponseDTO<T> {

    private Integer status;
    private String message;
    private T result;

}