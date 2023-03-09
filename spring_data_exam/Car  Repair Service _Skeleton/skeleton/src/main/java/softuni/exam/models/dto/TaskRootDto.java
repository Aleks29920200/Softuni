package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="tasks")
@XmlAccessorType(value= XmlAccessType.FIELD)
public class TaskRootDto {
    @XmlElement(name="task")
    private List<TaskDto> task;

    public List<TaskDto> getTask() {
        return task;
    }

    public void setTask(List<TaskDto> task) {
        this.task = task;
    }
}
