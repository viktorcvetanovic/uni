package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Porudzbina {
    private int id;
    private int id_kupca;
    private int brojDanaIsporuke;
}
