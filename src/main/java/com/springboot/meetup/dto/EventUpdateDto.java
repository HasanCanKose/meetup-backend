package com.springboot.meetup.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventUpdateDto {

    private int id;
    private String title;
    private String description;
    private String place;
    private String date;
}
