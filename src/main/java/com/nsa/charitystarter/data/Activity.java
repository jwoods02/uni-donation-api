package com.nsa.charitystarter.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
     private String who;
     private String what;
     private LocalDateTime when;
}
