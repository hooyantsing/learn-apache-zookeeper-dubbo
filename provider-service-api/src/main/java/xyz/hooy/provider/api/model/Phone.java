package xyz.hooy.provider.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Phone implements Serializable {

    private String name;
    private String type;
}
