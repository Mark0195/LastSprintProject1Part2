package SqlDatabase.DataRest;

import javax.persistence.*;

@Entity
public class mock_data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String animals;
    private String commonName;

    public mock_data() {

    }

    public mock_data(long id, String animals, String common_name) {
        this.id = id;
        this.animals = animals;
        this.commonName = common_name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnimals() {
        return animals;
    }

    public void setAnimals(String animals) {
        this.animals = animals;
    }

    public String getCommon_name() {
        return commonName;
    }

    public void setCommon_name(String common_name) {
        this.commonName = common_name;
    }
}