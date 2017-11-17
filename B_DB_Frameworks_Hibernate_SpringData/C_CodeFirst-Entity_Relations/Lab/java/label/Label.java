package label;

import shampoo.BasicShampoo;

import java.io.Serializable;

public interface Label extends Serializable{

    int getId();

    void setId(int id);

    String getTitle();

    void setTitle(String title);

    String getSubTitle();

    void setSubTitle(String subTitle);

    BasicShampoo getBasicShampoo();

    void setBasicShampoo(BasicShampoo basicShampoo);
}
