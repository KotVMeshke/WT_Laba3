package org.education.beans.dto;

import jakarta.servlet.http.Part;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AddProductDTO {

    String nameP;
    String price;
    String category;
    MultipartFile image;


}
