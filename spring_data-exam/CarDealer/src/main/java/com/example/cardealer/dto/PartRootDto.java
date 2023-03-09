package com.example.cardealer.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartRootDto {

    @XmlElement(name = "part")
    private List<PartInputDto> partDtos;

    public PartRootDto() {
    }

    public List<PartInputDto> getPartDtos() {
        return partDtos;
    }

    public void setPartDtos(List<PartInputDto> partDtos) {
        this.partDtos = partDtos;
    }
}
