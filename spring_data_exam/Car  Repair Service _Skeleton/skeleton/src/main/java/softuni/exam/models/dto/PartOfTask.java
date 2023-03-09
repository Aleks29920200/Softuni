package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="part")
@XmlAccessorType(value= XmlAccessType.FIELD)
public class PartOfTask {
    @XmlElement
    private long id;

    public long getId() {
        return id;
    }
}
