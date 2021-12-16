package SqlDatabase.Controller;
import SqlDatabase.DataRest.mock_data;
import SqlDatabase.Repo.MockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8083")
@RestController
@RequestMapping("/api")
public class MockController {
    @Autowired
    MockRepo mockRepo;


    @GetMapping("/animal")
    public ResponseEntity<List<mock_data>> getAllAnimals(@RequestParam(required = false) String animals) {
        try {
            List<mock_data> mock = new ArrayList<mock_data>();
            if (animals == null)
                mockRepo.findAll().forEach(mock::add);
            else
                mockRepo.findByAnimals(animals).forEach(mock::add);

            if (mock.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(mock, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/animal/{animal_id}", produces = "application/json")
    public ResponseEntity<mock_data> getAnimalsByAnimal_Id(@PathVariable("id") long id) {
        Optional<mock_data> id1 = mockRepo.findById(id);
        return id1.map(animal -> new ResponseEntity<>(animal, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/animal")
    public ResponseEntity<mock_data> createAnimals(@RequestBody mock_data animal) {
        try {
            mock_data _animal = mockRepo
                    .save(new mock_data(animal.getId(),
                            animal.getAnimals(), animal.getCommon_name()));
            return new ResponseEntity<>(_animal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
