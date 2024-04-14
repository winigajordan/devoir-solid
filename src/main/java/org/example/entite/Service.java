package org.example.entite;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service {
    private static Long nbrService = 0L;
    private Long id;
    private String code;
    private String nom;

    public Service() {
        this.id = ++nbrService;

    }

    @Override
    public String toString() {
        return
                "id=" + id +
                " \n code='" + code +
                "\n nom='" + nom  +
                "\n ---------------------------------------------------------------- \n ";
    }
}
