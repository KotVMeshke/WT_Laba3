package org.education.beans.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BanDTO {
    @Size(min = 5, message = "Too short username")
    String name;
}
