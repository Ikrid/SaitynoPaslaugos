package Model;
import javax.xml.bind.annotation.XmlElement;

public class Subject {

    private String code;
    private String name;
    private int credits;

    public String getCode() {
        return code;
    }

    @XmlElement
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    @XmlElement
    public void setCredits(int credits) {
        this.credits = credits;
    }
}
