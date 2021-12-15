package SqlDatabase.DataRest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class mock_dataTest {
    @Test
    void testConstructor() {
        mock_data actualMock_data = new mock_data();
        actualMock_data.setAnimals("Animals");
        actualMock_data.setCommon_name("Common name");
        actualMock_data.setId(123L);
        assertEquals("Animals", actualMock_data.getAnimals());
        assertEquals("Common name", actualMock_data.getCommon_name());
        assertEquals(123L, actualMock_data.getId());
    }
}

